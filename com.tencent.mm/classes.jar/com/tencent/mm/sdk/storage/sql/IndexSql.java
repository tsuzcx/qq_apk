package com.tencent.mm.sdk.storage.sql;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/IndexSql;", "Lcom/tencent/mm/sdk/storage/sql/SqlObj;", "sql", "", "(Ljava/lang/String;)V", "Builder", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class IndexSql
  extends SqlObj
{
  public IndexSql(String paramString)
  {
    super(paramString, null);
    AppMethodBeat.i(244377);
    AppMethodBeat.o(244377);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/storage/sql/IndexSql$Builder;", "", "table", "Lcom/tencent/mm/sdk/storage/sql/Table;", "name", "", "(Lcom/tencent/mm/sdk/storage/sql/Table;Ljava/lang/String;)V", "columns", "", "Lcom/tencent/mm/sdk/storage/sql/ISqlColumn;", "isUnique", "", "logTag", "getName", "()Ljava/lang/String;", "getTable", "()Lcom/tencent/mm/sdk/storage/sql/Table;", "build", "Lcom/tencent/mm/sdk/storage/sql/IndexSql;", "log", "tag", "on", "", "([Lcom/tencent/mm/sdk/storage/sql/ISqlColumn;)Lcom/tencent/mm/sdk/storage/sql/IndexSql$Builder;", "wechat-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Builder
  {
    private List<? extends ISqlColumn> columns;
    private boolean isUnique;
    private String logTag;
    private final String name;
    private final Table table;
    
    public Builder(Table paramTable, String paramString)
    {
      AppMethodBeat.i(244411);
      this.table = paramTable;
      this.name = paramString;
      AppMethodBeat.o(244411);
    }
    
    public final IndexSql build()
    {
      int i = 1;
      String str = null;
      AppMethodBeat.i(244461);
      if (!(this.table instanceof SingleTable))
      {
        localObject = new IllegalArgumentException("Not support multi table index");
        AppMethodBeat.o(244461);
        throw ((Throwable)localObject);
      }
      if (this.columns != null)
      {
        localObject = this.columns;
        if ((localObject == null) || (((List)localObject).isEmpty() != true)) {
          break label83;
        }
      }
      while (i != 0)
      {
        localObject = new IllegalArgumentException("empty columns");
        AppMethodBeat.o(244461);
        throw ((Throwable)localObject);
        label83:
        i = 0;
      }
      StringBuilder localStringBuilder = new StringBuilder("CREATE ");
      if (this.isUnique)
      {
        localObject = "UNIQUE ";
        localStringBuilder = localStringBuilder.append((String)localObject).append("INDEX IF NOT EXISTS ").append(this.name).append(" ON ").append(((SingleTable)this.table).getName()).append('(');
        localObject = this.columns;
        if (localObject != null) {
          break label219;
        }
      }
      label219:
      for (Object localObject = str;; localObject = p.a((Iterable)localObject, (CharSequence)",", null, null, 0, null, (b)build.sql.1.INSTANCE, 30))
      {
        localObject = localObject + ')';
        str = this.logTag;
        if (str != null) {
          Log.i(str, s.X("IndexSql.Builder: sql=", localObject));
        }
        localObject = new IndexSql((String)localObject);
        AppMethodBeat.o(244461);
        return localObject;
        localObject = "";
        break;
      }
    }
    
    public final String getName()
    {
      return this.name;
    }
    
    public final Table getTable()
    {
      return this.table;
    }
    
    public final Builder isUnique(boolean paramBoolean)
    {
      this.isUnique = paramBoolean;
      return this;
    }
    
    public final Builder log(String paramString)
    {
      AppMethodBeat.i(244450);
      s.u(paramString, "tag");
      this.logTag = paramString;
      AppMethodBeat.o(244450);
      return this;
    }
    
    public final Builder on(List<? extends ISqlColumn> paramList)
    {
      AppMethodBeat.i(244429);
      s.u(paramList, "columns");
      this.columns = paramList;
      AppMethodBeat.o(244429);
      return this;
    }
    
    public final Builder on(ISqlColumn... paramVarArgs)
    {
      AppMethodBeat.i(244436);
      s.u(paramVarArgs, "columns");
      Collection localCollection = (Collection)new ArrayList(paramVarArgs.length);
      int j = paramVarArgs.length;
      int i = 0;
      while (i < j)
      {
        localCollection.add(paramVarArgs[i]);
        i += 1;
      }
      this.columns = ((List)localCollection);
      AppMethodBeat.o(244436);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.sql.IndexSql
 * JD-Core Version:    0.7.0.1
 */