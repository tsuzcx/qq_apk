package com.tencent.mm.plugin.story.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.contact.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.story.a.a;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.i.a.f;
import com.tencent.mm.plugin.story.i.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "adapter", "Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$ContactsAdapter;", "blackList", "Ljava/util/ArrayList;", "", "contactLV", "Landroid/widget/ListView;", "groupList", "localId", "", "storyInfo", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "titile", "userNames", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "prepareData", "Companion", "ContactsAdapter", "ViewHolder", "plugin-story_release"})
public final class StoryRangeDetailUI
  extends MMActivity
{
  public static final a LRn;
  private static final String TAG = "MicroMsg.StoryRangeDetailUI";
  private ListView Een;
  private com.tencent.mm.plugin.story.i.j LKu;
  private b LRl;
  private String LRm;
  private int fWh;
  private final ArrayList<String> jLM;
  private final ArrayList<String> jmv;
  private final ArrayList<String> nXH;
  
  static
  {
    AppMethodBeat.i(119657);
    LRn = new a((byte)0);
    TAG = "MicroMsg.StoryRangeDetailUI";
    AppMethodBeat.o(119657);
  }
  
  public StoryRangeDetailUI()
  {
    AppMethodBeat.i(119656);
    this.jmv = new ArrayList();
    this.jLM = new ArrayList();
    this.nXH = new ArrayList();
    AppMethodBeat.o(119656);
  }
  
  public final int getLayoutId()
  {
    return a.e.LDn;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(119654);
    setMMTitle(this.LRm);
    Object localObject = findViewById(a.d.address_contactlist);
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(119654);
      throw ((Throwable)localObject);
    }
    this.Een = ((ListView)localObject);
    localObject = this.Een;
    if (localObject != null) {
      ((ListView)localObject).setBackgroundColor(getResources().getColor(a.a.white));
    }
    localObject = this.Een;
    if (localObject != null) {}
    for (localObject = ((ListView)localObject).getParent(); localObject == null; localObject = null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.View");
      AppMethodBeat.o(119654);
      throw ((Throwable)localObject);
    }
    ((View)localObject).setBackgroundColor(getResources().getColor(a.a.white));
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    showOptionMenu(false);
    if ((this.jmv != null) && (this.jmv.size() != 0))
    {
      this.LRl = new b((Context)this, (List)this.jmv);
      localObject = this.Een;
      if (localObject != null) {
        ((ListView)localObject).setAdapter((ListAdapter)this.LRl);
      }
      localObject = this.Een;
      if (localObject != null) {
        ((ListView)localObject).setVisibility(0);
      }
      localObject = this.Een;
      if (localObject != null)
      {
        ((ListView)localObject).setOnItemClickListener((AdapterView.OnItemClickListener)new e(this));
        AppMethodBeat.o(119654);
        return;
      }
    }
    AppMethodBeat.o(119654);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119653);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    Object localObject = a.f.LPT;
    this.fWh = paramBundle.getIntExtra(a.f.gfN(), -1);
    paramBundle = com.tencent.mm.plugin.story.f.j.LGA;
    this.LKu = j.b.gcw().aiv(this.fWh);
    localObject = this.jLM;
    paramBundle = this.LKu;
    if (paramBundle != null)
    {
      paramBundle = (Collection)paramBundle.aCq();
      ((ArrayList)localObject).addAll(paramBundle);
      localObject = this.nXH;
      paramBundle = this.LKu;
      if (paramBundle == null) {
        break label191;
      }
      paramBundle = (Collection)paramBundle.gga();
      label99:
      ((ArrayList)localObject).addAll(paramBundle);
      if (this.fWh != -1)
      {
        paramBundle = (Collection)this.jLM;
        if ((paramBundle != null) && (!paramBundle.isEmpty())) {
          break label205;
        }
        i = 1;
        label136:
        if (i == 0) {
          break label215;
        }
        paramBundle = (Collection)this.nXH;
        if ((paramBundle != null) && (!paramBundle.isEmpty())) {
          break label210;
        }
      }
    }
    label191:
    label205:
    label210:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label215;
      }
      finish();
      AppMethodBeat.o(119653);
      return;
      paramBundle = (Collection)new ArrayList();
      break;
      paramBundle = (Collection)new ArrayList();
      break label99;
      i = 0;
      break label136;
    }
    label215:
    paramBundle = (Collection)this.nXH;
    if ((paramBundle == null) || (paramBundle.isEmpty()))
    {
      i = 1;
      if (i != 0) {
        break label283;
      }
      this.LRm = getString(a.g.LEh);
      this.jmv.addAll((Collection)this.nXH);
    }
    label283:
    label342:
    for (;;)
    {
      initView();
      AppMethodBeat.o(119653);
      return;
      i = 0;
      break;
      paramBundle = (Collection)this.jLM;
      if ((paramBundle == null) || (paramBundle.isEmpty())) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label342;
        }
        this.LRm = getString(a.g.LEi);
        this.jmv.addAll((Collection)this.jLM);
        break;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(119655);
    super.onResume();
    if (this.LRl != null)
    {
      b localb = this.LRl;
      if (localb != null)
      {
        localb.notifyDataSetChanged();
        AppMethodBeat.o(119655);
        return;
      }
    }
    AppMethodBeat.o(119655);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$Companion;", "", "()V", "TAG", "", "plugin-story_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$ContactsAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "userNames", "", "", "(Landroid/content/Context;Ljava/util/List;)V", "cstg", "Lcom/tencent/mm/storage/IContactStorage;", "list", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/contact/RContact;", "normal", "Landroid/content/res/ColorStateList;", "spuser", "getCount", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "plugin-story_release"})
  static final class b
    extends BaseAdapter
  {
    private bv KOY;
    private final HashMap<Integer, d> LRo;
    private ColorStateList LRp;
    private ColorStateList LRq;
    private Context context;
    
    /* Error */
    public b(Context paramContext, List<String> paramList)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_3
      //   2: aload_1
      //   3: ldc 51
      //   5: invokestatic 57	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
      //   8: aload_2
      //   9: ldc 58
      //   11: invokestatic 57	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
      //   14: aload_0
      //   15: invokespecial 61	android/widget/BaseAdapter:<init>	()V
      //   18: ldc 62
      //   20: invokestatic 68	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   23: aload_0
      //   24: aload_1
      //   25: putfield 70	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:context	Landroid/content/Context;
      //   28: aload_0
      //   29: new 72	java/util/HashMap
      //   32: dup
      //   33: invokespecial 73	java/util/HashMap:<init>	()V
      //   36: putfield 75	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:LRo	Ljava/util/HashMap;
      //   39: aload_0
      //   40: getfield 75	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:LRo	Ljava/util/HashMap;
      //   43: invokevirtual 78	java/util/HashMap:clear	()V
      //   46: ldc 80
      //   48: invokestatic 86	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
      //   51: astore 5
      //   53: aload 5
      //   55: ldc 88
      //   57: invokestatic 91	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
      //   60: aload_0
      //   61: aload 5
      //   63: checkcast 80	com/tencent/mm/plugin/messenger/foundation/a/n
      //   66: invokeinterface 95 1 0
      //   71: putfield 97	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:KOY	Lcom/tencent/mm/storage/bv;
      //   74: aload_2
      //   75: invokeinterface 103 1 0
      //   80: astore_2
      //   81: aload_2
      //   82: invokeinterface 109 1 0
      //   87: ifeq +103 -> 190
      //   90: aload_2
      //   91: invokeinterface 113 1 0
      //   96: checkcast 115	java/lang/String
      //   99: astore 5
      //   101: aload_0
      //   102: getfield 97	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:KOY	Lcom/tencent/mm/storage/bv;
      //   105: astore 6
      //   107: aload 6
      //   109: ifnonnull +6 -> 115
      //   112: invokestatic 118	kotlin/g/b/p:iCn	()V
      //   115: aload 6
      //   117: aload 5
      //   119: invokeinterface 124 2 0
      //   124: astore 6
      //   126: iload_3
      //   127: istore 4
      //   129: aload 6
      //   131: ifnull +53 -> 184
      //   134: iload_3
      //   135: istore 4
      //   137: aload 6
      //   139: invokevirtual 129	com/tencent/mm/storage/as:axZ	()Z
      //   142: ifeq +42 -> 184
      //   145: iload_3
      //   146: istore 4
      //   148: aload 5
      //   150: invokestatic 135	com/tencent/mm/model/z:PD	(Ljava/lang/String;)Z
      //   153: ifne +31 -> 184
      //   156: aload_0
      //   157: getfield 75	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:LRo	Ljava/util/HashMap;
      //   160: checkcast 137	java/util/Map
      //   163: astore 5
      //   165: iload_3
      //   166: iconst_1
      //   167: iadd
      //   168: istore 4
      //   170: aload 5
      //   172: iload_3
      //   173: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   176: aload 6
      //   178: invokeinterface 147 3 0
      //   183: pop
      //   184: iload 4
      //   186: istore_3
      //   187: goto -106 -> 81
      //   190: aload_1
      //   191: invokevirtual 153	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   194: getstatic 159	com/tencent/mm/plugin/story/a$a:mm_list_textcolor_one	I
      //   197: invokevirtual 165	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   200: astore_2
      //   201: aload_1
      //   202: invokevirtual 153	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   205: getstatic 168	com/tencent/mm/plugin/story/a$a:mm_list_textcolor_spuser	I
      //   208: invokevirtual 165	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
      //   211: astore 7
      //   213: aload_2
      //   214: astore 6
      //   216: aload 7
      //   218: astore 5
      //   220: aload_0
      //   221: aload_1
      //   222: invokevirtual 153	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   225: aload_2
      //   226: checkcast 170	org/xmlpull/v1/XmlPullParser
      //   229: invokestatic 176	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
      //   232: putfield 178	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:LRp	Landroid/content/res/ColorStateList;
      //   235: aload_2
      //   236: astore 6
      //   238: aload 7
      //   240: astore 5
      //   242: aload_0
      //   243: aload_1
      //   244: invokevirtual 153	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   247: aload 7
      //   249: checkcast 170	org/xmlpull/v1/XmlPullParser
      //   252: invokestatic 176	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
      //   255: putfield 180	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$b:LRq	Landroid/content/res/ColorStateList;
      //   258: aload_2
      //   259: ifnull +9 -> 268
      //   262: aload_2
      //   263: invokeinterface 185 1 0
      //   268: aload 7
      //   270: ifnull +16 -> 286
      //   273: aload 7
      //   275: invokeinterface 185 1 0
      //   280: ldc 62
      //   282: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   285: return
      //   286: ldc 62
      //   288: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   291: return
      //   292: astore_1
      //   293: aconst_null
      //   294: astore 7
      //   296: aconst_null
      //   297: astore_2
      //   298: aload_2
      //   299: astore 6
      //   301: aload 7
      //   303: astore 5
      //   305: invokestatic 192	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI:access$getTAG$cp	()Ljava/lang/String;
      //   308: aload_1
      //   309: checkcast 194	java/lang/Throwable
      //   312: ldc 195
      //   314: iconst_0
      //   315: anewarray 197	java/lang/Object
      //   318: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   321: aload_2
      //   322: ifnull +9 -> 331
      //   325: aload_2
      //   326: invokeinterface 185 1 0
      //   331: aload 7
      //   333: ifnull +16 -> 349
      //   336: aload 7
      //   338: invokeinterface 185 1 0
      //   343: ldc 62
      //   345: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   348: return
      //   349: ldc 62
      //   351: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   354: return
      //   355: astore_1
      //   356: aconst_null
      //   357: astore 7
      //   359: aconst_null
      //   360: astore_2
      //   361: aload_2
      //   362: astore 6
      //   364: aload 7
      //   366: astore 5
      //   368: invokestatic 192	com/tencent/mm/plugin/story/ui/StoryRangeDetailUI:access$getTAG$cp	()Ljava/lang/String;
      //   371: aload_1
      //   372: checkcast 194	java/lang/Throwable
      //   375: ldc 195
      //   377: iconst_0
      //   378: anewarray 197	java/lang/Object
      //   381: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   384: aload_2
      //   385: ifnull +9 -> 394
      //   388: aload_2
      //   389: invokeinterface 185 1 0
      //   394: aload 7
      //   396: ifnull +16 -> 412
      //   399: aload 7
      //   401: invokeinterface 185 1 0
      //   406: ldc 62
      //   408: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   411: return
      //   412: ldc 62
      //   414: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   417: return
      //   418: astore_1
      //   419: aconst_null
      //   420: astore 5
      //   422: aconst_null
      //   423: astore_2
      //   424: aload_2
      //   425: ifnull +9 -> 434
      //   428: aload_2
      //   429: invokeinterface 185 1 0
      //   434: aload 5
      //   436: ifnull +10 -> 446
      //   439: aload 5
      //   441: invokeinterface 185 1 0
      //   446: ldc 62
      //   448: invokestatic 188	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   451: aload_1
      //   452: athrow
      //   453: astore_1
      //   454: aconst_null
      //   455: astore 5
      //   457: goto -33 -> 424
      //   460: astore_1
      //   461: aload 6
      //   463: astore_2
      //   464: goto -40 -> 424
      //   467: astore_1
      //   468: aconst_null
      //   469: astore 7
      //   471: goto -110 -> 361
      //   474: astore_1
      //   475: goto -114 -> 361
      //   478: astore_1
      //   479: aconst_null
      //   480: astore 7
      //   482: goto -184 -> 298
      //   485: astore_1
      //   486: goto -188 -> 298
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	489	0	this	b
      //   0	489	1	paramContext	Context
      //   0	489	2	paramList	List<String>
      //   1	186	3	i	int
      //   127	58	4	j	int
      //   51	405	5	localObject1	Object
      //   105	357	6	localObject2	Object
      //   211	270	7	localXmlResourceParser	android.content.res.XmlResourceParser
      // Exception table:
      //   from	to	target	type
      //   190	201	292	org/xmlpull/v1/XmlPullParserException
      //   190	201	355	java/io/IOException
      //   190	201	418	finally
      //   201	213	453	finally
      //   220	235	460	finally
      //   242	258	460	finally
      //   305	321	460	finally
      //   368	384	460	finally
      //   201	213	467	java/io/IOException
      //   220	235	474	java/io/IOException
      //   242	258	474	java/io/IOException
      //   201	213	478	org/xmlpull/v1/XmlPullParserException
      //   220	235	485	org/xmlpull/v1/XmlPullParserException
      //   242	258	485	org/xmlpull/v1/XmlPullParserException
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(119647);
      int i = this.LRo.size();
      AppMethodBeat.o(119647);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(119648);
      if (paramInt < 0)
      {
        AppMethodBeat.o(119648);
        return null;
      }
      d locald = (d)this.LRo.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(119648);
      return locald;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(119649);
      p.k(paramViewGroup, "parent");
      if (paramView == null)
      {
        paramView = View.inflate(this.context, a.e.LDm, null);
        paramViewGroup = new StoryRangeDetailUI.c();
        if (paramView == null) {
          p.iCn();
        }
        localObject1 = paramView.findViewById(a.d.dCx);
        if (localObject1 == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(119649);
          throw paramView;
        }
        paramViewGroup.DUW = ((TextView)localObject1);
        localObject1 = paramView.findViewById(a.d.dCv);
        if (localObject1 == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.MaskLayout");
          AppMethodBeat.o(119649);
          throw paramView;
        }
        paramViewGroup.jkT = ((MaskLayout)localObject1);
        localObject1 = paramView.findViewById(a.d.dCB);
        if (localObject1 == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(119649);
          throw paramView;
        }
        paramViewGroup.jbe = ((TextView)localObject1);
        localObject1 = paramView.findViewById(a.d.dCt);
        if (localObject1 == null)
        {
          paramView = new t("null cannot be cast to non-null type android.widget.TextView");
          AppMethodBeat.o(119649);
          throw paramView;
        }
        paramViewGroup.LRr = ((TextView)localObject1);
        paramView.setTag(paramViewGroup);
        getItem(paramInt);
        localObject2 = (d)getItem(paramInt);
        localObject1 = paramViewGroup.DUW;
        if (localObject1 == null) {
          p.iCn();
        }
        ((TextView)localObject1).setVisibility(8);
        localObject3 = paramViewGroup.jbe;
        if (localObject3 == null) {
          p.iCn();
        }
        if (localObject2 == null) {
          p.iCn();
        }
        if (ab.QX(((d)localObject2).getUsername())) {
          break label370;
        }
      }
      label370:
      for (Object localObject1 = this.LRp;; localObject1 = this.LRq)
      {
        ((TextView)localObject3).setTextColor((ColorStateList)localObject1);
        localObject1 = paramViewGroup.jkT;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((MaskLayout)localObject1).getContentView();
        if (localObject1 != null) {
          break label379;
        }
        paramView = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(119649);
        throw paramView;
        paramViewGroup = paramView.getTag();
        if (paramViewGroup == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.StoryRangeDetailUI.ViewHolder");
          AppMethodBeat.o(119649);
          throw paramView;
        }
        paramViewGroup = (StoryRangeDetailUI.c)paramViewGroup;
        break;
      }
      label379:
      a.b.C((ImageView)localObject1, ((d)localObject2).getUsername());
      localObject1 = paramViewGroup.LRr;
      if (localObject1 == null) {
        p.iCn();
      }
      ((TextView)localObject1).setVisibility(8);
      localObject1 = paramViewGroup.jkT;
      if (localObject1 == null) {
        p.iCn();
      }
      ((MaskLayout)localObject1).setVisibility(0);
      localObject1 = paramViewGroup.jbe;
      if (localObject1 == null) {
        p.iCn();
      }
      Object localObject3 = this.context;
      Object localObject2 = (CharSequence)((d)localObject2).ays();
      TextView localTextView = paramViewGroup.jbe;
      if (localTextView == null) {
        p.iCn();
      }
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.b((Context)localObject3, (CharSequence)localObject2, localTextView.getTextSize()));
      paramViewGroup = paramViewGroup.jbe;
      if (paramViewGroup == null) {
        p.iCn();
      }
      paramViewGroup.setVisibility(0);
      AppMethodBeat.o(119649);
      return paramView;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/StoryRangeDetailUI$ViewHolder;", "", "()V", "avatarIV", "Lcom/tencent/mm/ui/base/MaskLayout;", "getAvatarIV$plugin_story_release", "()Lcom/tencent/mm/ui/base/MaskLayout;", "setAvatarIV$plugin_story_release", "(Lcom/tencent/mm/ui/base/MaskLayout;)V", "catalog", "Landroid/widget/TextView;", "getCatalog$plugin_story_release", "()Landroid/widget/TextView;", "setCatalog$plugin_story_release", "(Landroid/widget/TextView;)V", "nickTV", "getNickTV$plugin_story_release", "setNickTV$plugin_story_release", "weixinTV", "getWeixinTV$plugin_story_release", "setWeixinTV$plugin_story_release", "plugin-story_release"})
  static final class c
  {
    TextView DUW;
    TextView LRr;
    TextView jbe;
    MaskLayout jkT;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(StoryRangeDetailUI paramStoryRangeDetailUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(119651);
      this.LRs.finish();
      AppMethodBeat.o(119651);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class e
    implements AdapterView.OnItemClickListener
  {
    e(StoryRangeDetailUI paramStoryRangeDetailUI) {}
    
    public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
    {
      AppMethodBeat.i(119652);
      b localb = new b();
      localb.bn(paramAdapterView);
      localb.bn(paramView);
      localb.sg(paramInt);
      localb.Fs(paramLong);
      a.c("com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
      paramAdapterView = StoryRangeDetailUI.a(this.LRs);
      if (paramAdapterView != null) {}
      for (paramAdapterView = paramAdapterView.getItem(paramInt); paramAdapterView == null; paramAdapterView = null)
      {
        paramAdapterView = new t("null cannot be cast to non-null type com.tencent.mm.contact.RContact");
        AppMethodBeat.o(119652);
        throw paramAdapterView;
      }
      paramAdapterView = (d)paramAdapterView;
      paramView = new Intent();
      paramView.putExtra("Contact_User", paramAdapterView.getUsername());
      paramView.putExtra("CONTACT_INFO_UI_SOURCE", 12);
      c.b((Context)this.LRs.getContext(), "profile", ".ui.ContactInfoUI", paramView);
      a.a(this, "com/tencent/mm/plugin/story/ui/StoryRangeDetailUI$initView$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(119652);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryRangeDetailUI
 * JD-Core Version:    0.7.0.1
 */