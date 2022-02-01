package com.tencent.mm.plugin.p;

import androidx.lifecycle.aa;
import androidx.lifecycle.r;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import androidx.lifecycle.y.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.l.b;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/BaseMMLiveDB;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelStoreOwner;", "()V", "liveData", "Landroidx/lifecycle/MutableLiveData;", "", "storageOwner", "Landroidx/lifecycle/ViewModelStore;", "collectFinderDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "getDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "getStorage", "T", "Lcom/tencent/mm/plugin/livestorage/MMLiveStorage;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/tencent/mm/plugin/livestorage/MMLiveStorage;", "getViewModelStore", "onCleared", "", "updateTableInfo", "Companion", "EntityFactory", "InnerLifeDBProvider", "plugin-livestorage_release"})
public abstract class a
  extends x
  implements androidx.lifecycle.ab
{
  public static final a.a EiP = new a.a((byte)0);
  private final r<String> EiN = new r();
  private final aa EiO = new aa();
  
  public final <T extends h<? extends IAutoDBItem>> T bi(Class<T> paramClass)
  {
    p.k(paramClass, "modelClass");
    paramClass = new y(this.EiO, (y.b)new d(this)).i(paramClass);
    p.j(paramClass, "ViewModelProvider(storag…       }).get(modelClass)");
    return (h)paramClass;
  }
  
  protected final HashMap<Integer, h.b> collectFinderDatabaseFactory()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = (f)getClass().getAnnotation(f.class);
    if (localObject != null)
    {
      localObject = kotlin.g.b.ab.d(((f)localObject).eLU());
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          b localb = localObject[i];
          String str = ((IAutoDBItem)kotlin.g.a.a(localb).newInstance()).getTableName();
          Log.i("MicroMsg.Mvvm.BaseMMLiveDB", "collectFinderDatabaseFactory tableName:".concat(String.valueOf(str)));
          Map localMap = (Map)localHashMap;
          int k = str.hashCode();
          p.j(str, "tableName");
          localMap.put(Integer.valueOf(k), new b(localb, str));
          i += 1;
        }
      }
    }
    return localHashMap;
  }
  
  protected final void eLS()
  {
    Object localObject1 = (f)getClass().getAnnotation(f.class);
    if (localObject1 != null)
    {
      localObject1 = kotlin.g.b.ab.d(((f)localObject1).eLU());
      if (localObject1 != null)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          com.tencent.mm.storagebase.h localh = getDB();
          if (localh != null)
          {
            Object localObject3 = (IAutoDBItem)kotlin.g.a.a((b)localObject2).newInstance();
            localObject2 = ((IAutoDBItem)localObject3).getTableName();
            localObject3 = MAutoStorage.getUpdateSQLs(((IAutoDBItem)localObject3).getDBInfo(), (String)localObject2, (ISQLiteDatabase)localh);
            if (localObject3 != null)
            {
              localObject3 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                String str = (String)((Iterator)localObject3).next();
                Log.i("MicroMsg.Mvvm.BaseMMLiveDB", "exec SQL ".concat(String.valueOf(str)));
                localh.execSQL((String)localObject2, str);
              }
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public abstract com.tencent.mm.storagebase.h getDB();
  
  public aa getViewModelStore()
  {
    return this.EiO;
  }
  
  public void onCleared()
  {
    this.EiO.clear();
    com.tencent.mm.storagebase.h localh = getDB();
    if ((localh != null) && (localh.isOpen() == true))
    {
      localh = getDB();
      if (localh != null) {
        localh.closeDB();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/BaseMMLiveDB$EntityFactory;", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "clazz", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "tableName", "", "(Lcom/tencent/mm/plugin/livestorage/BaseMMLiveDB;Lkotlin/reflect/KClass;Ljava/lang/String;)V", "getClazz", "()Lkotlin/reflect/KClass;", "getTableName", "()Ljava/lang/String;", "getSQLs", "", "()[Ljava/lang/String;", "plugin-livestorage_release"})
  public final class b
    implements h.b
  {
    private final b<? extends IAutoDBItem> EiQ;
    private final String tableName;
    
    public b(String paramString)
    {
      AppMethodBeat.i(254482);
      this.EiQ = paramString;
      this.tableName = localObject;
      AppMethodBeat.o(254482);
    }
    
    public final String[] getSQLs()
    {
      AppMethodBeat.i(254480);
      Object localObject1 = new ArrayList();
      Object localObject2 = MAutoStorage.getCreateSQLs(((IAutoDBItem)kotlin.g.a.a(this.EiQ).newInstance()).getDBInfo(), this.tableName);
      if (localObject2 != null) {
        ((ArrayList)localObject1).add(localObject2);
      }
      localObject2 = (Collection)localObject1;
      String[] arrayOfString = ((IAutoDBItem)kotlin.g.a.a(this.EiQ).newInstance()).getIndexCreateSQL();
      p.j(arrayOfString, "clazz.java.newInstance().indexCreateSQL");
      j.a((Collection)localObject2, arrayOfString);
      localObject1 = ((Collection)localObject1).toArray(new String[0]);
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(254480);
        throw ((Throwable)localObject1);
      }
      localObject1 = (String[])localObject1;
      AppMethodBeat.o(254480);
      return localObject1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livestorage/BaseMMLiveDB$InnerLifeDBProvider;", "Lcom/tencent/mm/plugin/livestorage/ILiveDBProvider;", "dbRef", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/plugin/livestorage/BaseMMLiveDB;Ljava/lang/ref/WeakReference;)V", "getDB", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "plugin-livestorage_release"})
  public final class c
    implements c
  {
    private final WeakReference<com.tencent.mm.storagebase.h> EiS;
    
    public c()
    {
      AppMethodBeat.i(254491);
      this.EiS = localObject;
      AppMethodBeat.o(254491);
    }
    
    public final ISQLiteDatabase eLT()
    {
      AppMethodBeat.i(254489);
      Object localObject = (com.tencent.mm.storagebase.h)this.EiS.get();
      if ((localObject != null) && (((com.tencent.mm.storagebase.h)localObject).isOpen() == true))
      {
        localObject = (ISQLiteDatabase)this.EiS.get();
        AppMethodBeat.o(254489);
        return localObject;
      }
      AppMethodBeat.o(254489);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/livestorage/BaseMMLiveDB$getStorage$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "plugin-livestorage_release"})
  public static final class d
    implements y.b
  {
    public final <T extends x> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(254347);
      p.k(paramClass, "modelClass");
      paramClass = (x)paramClass.getConstructor(new Class[] { c.class }).newInstance(new Object[] { new a.c(this.EiR, new WeakReference(this.EiR.getDB())) });
      AppMethodBeat.o(254347);
      return paramClass;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.p.a
 * JD-Core Version:    0.7.0.1
 */