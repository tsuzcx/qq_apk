package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.s;
import com.tencent.mm.n.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.MaskLayout;
import java.util.Map;

final class SnsLabelContactListUI$a
  extends BaseAdapter
{
  private Context context;
  private bd oWj;
  private Map<Integer, a> vNV;
  private ColorStateList vNW;
  private ColorStateList vNX;
  
  /* Error */
  public SnsLabelContactListUI$a(Context paramContext, java.util.List<java.lang.String> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 26	android/widget/BaseAdapter:<init>	()V
    //   4: aload_0
    //   5: aconst_null
    //   6: putfield 28	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:context	Landroid/content/Context;
    //   9: aload_0
    //   10: new 30	java/util/HashMap
    //   13: dup
    //   14: invokespecial 31	java/util/HashMap:<init>	()V
    //   17: putfield 33	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:vNV	Ljava/util/Map;
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 35	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:oWj	Lcom/tencent/mm/storage/bd;
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 28	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:context	Landroid/content/Context;
    //   30: aload_0
    //   31: getfield 33	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:vNV	Ljava/util/Map;
    //   34: invokeinterface 40 1 0
    //   39: invokestatic 46	com/tencent/mm/model/au:Hx	()Lcom/tencent/mm/model/c;
    //   42: pop
    //   43: aload_0
    //   44: invokestatic 52	com/tencent/mm/model/c:Fw	()Lcom/tencent/mm/storage/bd;
    //   47: putfield 35	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:oWj	Lcom/tencent/mm/storage/bd;
    //   50: aload_2
    //   51: invokeinterface 58 1 0
    //   56: astore_2
    //   57: iconst_0
    //   58: istore_3
    //   59: aload_2
    //   60: invokeinterface 64 1 0
    //   65: ifeq +53 -> 118
    //   68: aload_2
    //   69: invokeinterface 68 1 0
    //   74: checkcast 70	java/lang/String
    //   77: astore 4
    //   79: new 72	com/tencent/mm/n/a
    //   82: dup
    //   83: invokespecial 73	com/tencent/mm/n/a:<init>	()V
    //   86: astore 5
    //   88: aload 5
    //   90: aload 4
    //   92: invokevirtual 77	com/tencent/mm/n/a:setUsername	(Ljava/lang/String;)V
    //   95: aload_0
    //   96: getfield 33	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:vNV	Ljava/util/Map;
    //   99: iload_3
    //   100: invokestatic 83	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: aload 5
    //   105: invokeinterface 87 3 0
    //   110: pop
    //   111: iload_3
    //   112: iconst_1
    //   113: iadd
    //   114: istore_3
    //   115: goto -56 -> 59
    //   118: aload_1
    //   119: invokevirtual 93	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   122: getstatic 99	com/tencent/mm/R$e:mm_list_textcolor_one	I
    //   125: invokevirtual 105	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   128: astore_2
    //   129: aload_1
    //   130: invokevirtual 93	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   133: getstatic 108	com/tencent/mm/R$e:mm_list_textcolor_spuser	I
    //   136: invokevirtual 105	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   139: astore 6
    //   141: aload 6
    //   143: astore 5
    //   145: aload_2
    //   146: astore 4
    //   148: aload_0
    //   149: aload_1
    //   150: invokevirtual 93	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   153: aload_2
    //   154: invokestatic 114	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
    //   157: putfield 116	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:vNW	Landroid/content/res/ColorStateList;
    //   160: aload 6
    //   162: astore 5
    //   164: aload_2
    //   165: astore 4
    //   167: aload_0
    //   168: aload_1
    //   169: invokevirtual 93	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   172: aload 6
    //   174: invokestatic 114	android/content/res/ColorStateList:createFromXml	(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;)Landroid/content/res/ColorStateList;
    //   177: putfield 118	com/tencent/mm/ui/contact/SnsLabelContactListUI$a:vNX	Landroid/content/res/ColorStateList;
    //   180: aload_2
    //   181: ifnull +9 -> 190
    //   184: aload_2
    //   185: invokeinterface 123 1 0
    //   190: aload 6
    //   192: ifnull +10 -> 202
    //   195: aload 6
    //   197: invokeinterface 123 1 0
    //   202: return
    //   203: astore_1
    //   204: aconst_null
    //   205: astore 6
    //   207: aconst_null
    //   208: astore_2
    //   209: aload 6
    //   211: astore 5
    //   213: aload_2
    //   214: astore 4
    //   216: ldc 125
    //   218: aload_1
    //   219: ldc 127
    //   221: iconst_0
    //   222: anewarray 129	java/lang/Object
    //   225: invokestatic 135	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   228: aload_2
    //   229: ifnull +9 -> 238
    //   232: aload_2
    //   233: invokeinterface 123 1 0
    //   238: aload 6
    //   240: ifnull -38 -> 202
    //   243: aload 6
    //   245: invokeinterface 123 1 0
    //   250: return
    //   251: astore_1
    //   252: aconst_null
    //   253: astore 6
    //   255: aconst_null
    //   256: astore_2
    //   257: aload 6
    //   259: astore 5
    //   261: aload_2
    //   262: astore 4
    //   264: ldc 125
    //   266: aload_1
    //   267: ldc 127
    //   269: iconst_0
    //   270: anewarray 129	java/lang/Object
    //   273: invokestatic 135	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   276: aload_2
    //   277: ifnull +9 -> 286
    //   280: aload_2
    //   281: invokeinterface 123 1 0
    //   286: aload 6
    //   288: ifnull -86 -> 202
    //   291: aload 6
    //   293: invokeinterface 123 1 0
    //   298: return
    //   299: astore_1
    //   300: aconst_null
    //   301: astore 5
    //   303: aconst_null
    //   304: astore_2
    //   305: aload_2
    //   306: ifnull +9 -> 315
    //   309: aload_2
    //   310: invokeinterface 123 1 0
    //   315: aload 5
    //   317: ifnull +10 -> 327
    //   320: aload 5
    //   322: invokeinterface 123 1 0
    //   327: aload_1
    //   328: athrow
    //   329: astore_1
    //   330: aconst_null
    //   331: astore 5
    //   333: goto -28 -> 305
    //   336: astore_1
    //   337: aload 4
    //   339: astore_2
    //   340: goto -35 -> 305
    //   343: astore_1
    //   344: aconst_null
    //   345: astore 6
    //   347: goto -90 -> 257
    //   350: astore_1
    //   351: goto -94 -> 257
    //   354: astore_1
    //   355: aconst_null
    //   356: astore 6
    //   358: goto -149 -> 209
    //   361: astore_1
    //   362: goto -153 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	a
    //   0	365	1	paramContext	Context
    //   0	365	2	paramList	java.util.List<java.lang.String>
    //   58	57	3	i	int
    //   77	261	4	localObject1	Object
    //   86	246	5	localObject2	Object
    //   139	218	6	localXmlResourceParser	android.content.res.XmlResourceParser
    // Exception table:
    //   from	to	target	type
    //   118	129	203	org/xmlpull/v1/XmlPullParserException
    //   118	129	251	java/io/IOException
    //   118	129	299	finally
    //   129	141	329	finally
    //   148	160	336	finally
    //   167	180	336	finally
    //   216	228	336	finally
    //   264	276	336	finally
    //   129	141	343	java/io/IOException
    //   148	160	350	java/io/IOException
    //   167	180	350	java/io/IOException
    //   129	141	354	org/xmlpull/v1/XmlPullParserException
    //   148	160	361	org/xmlpull/v1/XmlPullParserException
    //   167	180	361	org/xmlpull/v1/XmlPullParserException
  }
  
  public final int getCount()
  {
    return this.vNV.size();
  }
  
  public final Object getItem(int paramInt)
  {
    Object localObject;
    if (paramInt < 0) {
      localObject = null;
    }
    ad localad;
    do
    {
      a locala;
      do
      {
        return localObject;
        locala = (a)this.vNV.get(Integer.valueOf(paramInt));
        localObject = locala;
      } while (locala.field_showHead != 0);
      localad = this.oWj.abl(locala.field_username);
      localObject = locala;
    } while (localad == null);
    this.vNV.put(Integer.valueOf(paramInt), localad);
    return localad;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala;
    TextView localTextView;
    if (paramView == null)
    {
      paramView = View.inflate(this.context, R.i.contact_item, null);
      paramViewGroup = new SnsLabelContactListUI.c((byte)0);
      paramViewGroup.lvb = ((TextView)paramView.findViewById(R.h.contactitem_catalog));
      paramViewGroup.dsk = ((MaskLayout)paramView.findViewById(R.h.contactitem_avatar));
      paramViewGroup.drB = ((TextView)paramView.findViewById(R.h.contactitem_nick));
      paramViewGroup.vNZ = ((TextView)paramView.findViewById(R.h.contactitem_account));
      paramView.setTag(paramViewGroup);
      getItem(paramInt);
      locala = (a)getItem(paramInt);
      paramViewGroup.lvb.setVisibility(8);
      localTextView = paramViewGroup.drB;
      if (s.hU(locala.field_username)) {
        break label223;
      }
    }
    label223:
    for (ColorStateList localColorStateList = this.vNW;; localColorStateList = this.vNX)
    {
      localTextView.setTextColor(localColorStateList);
      a.b.p((ImageView)paramViewGroup.dsk.getContentView(), locala.field_username);
      paramViewGroup.vNZ.setVisibility(8);
      paramViewGroup.dsk.setVisibility(0);
      paramViewGroup.drB.setText(j.a(this.context, locala.Bq(), paramViewGroup.drB.getTextSize()));
      paramViewGroup.drB.setVisibility(0);
      return paramView;
      paramViewGroup = (SnsLabelContactListUI.c)paramView.getTag();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.SnsLabelContactListUI.a
 * JD-Core Version:    0.7.0.1
 */