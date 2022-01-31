package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.api.j;
import com.tencent.mm.h.c.az;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.gif.i;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;

public class EmojiInfo
  extends az
  implements Parcelable, j
{
  public static final Parcelable.Creator<EmojiInfo> CREATOR = new EmojiInfo.1();
  public static int TYPE_TEXT;
  protected static c.a buS;
  public static int uCP;
  public static int uCT;
  public static String uCU = ".gif";
  public static int uCV = 17;
  public static int uCW = 32;
  public static int uCX = 49;
  public static int uCY = 50;
  public static int uCZ;
  public static int uDa;
  public static int uDb;
  public static int uDc;
  public static int uDd;
  public static int uDe;
  public static int uDf;
  public static int uDg;
  public static int uDh;
  public static int uDi;
  public static int uDj;
  public static int uDk;
  public static int uDl;
  public static int uDm;
  public static int uDn;
  public static int uDo;
  public final String ndA;
  public String talker;
  
  static
  {
    uCT = 65;
    uCZ = 81;
    uCP = -1;
    uDa = 1;
    uDb = 2;
    uDc = 3;
    TYPE_TEXT = 4;
    uDd = 10;
    uDe = 11;
    uDf = 0;
    uDg = 1;
    uDh = 3;
    uDi = 4;
    uDj = 8;
    uDk = 0;
    uDl = 1;
    uDm = 0;
    uDn = 1;
    uDo = 1;
    c.a locala = new c.a();
    locala.ujL = new Field[35];
    locala.columns = new String[36];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "md5";
    locala.ujN.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    locala.ujM = "md5";
    locala.columns[1] = "svrid";
    locala.ujN.put("svrid", "TEXT");
    localStringBuilder.append(" svrid TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "catalog";
    locala.ujN.put("catalog", "INTEGER");
    localStringBuilder.append(" catalog INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "type";
    locala.ujN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "size";
    locala.ujN.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "start";
    locala.ujN.put("start", "INTEGER");
    localStringBuilder.append(" start INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "state";
    locala.ujN.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "name";
    locala.ujN.put("name", "TEXT");
    localStringBuilder.append(" name TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "content";
    locala.ujN.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "reserved1";
    locala.ujN.put("reserved1", "TEXT");
    localStringBuilder.append(" reserved1 TEXT");
    localStringBuilder.append(", ");
    locala.columns[10] = "reserved2";
    locala.ujN.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "reserved3";
    locala.ujN.put("reserved3", "INTEGER");
    localStringBuilder.append(" reserved3 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "reserved4";
    locala.ujN.put("reserved4", "INTEGER");
    localStringBuilder.append(" reserved4 INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "app_id";
    locala.ujN.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "groupId";
    locala.ujN.put("groupId", "TEXT default '' ");
    localStringBuilder.append(" groupId TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[15] = "lastUseTime";
    locala.ujN.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localStringBuilder.append(", ");
    locala.columns[16] = "framesInfo";
    locala.ujN.put("framesInfo", "TEXT default '' ");
    localStringBuilder.append(" framesInfo TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[17] = "idx";
    locala.ujN.put("idx", "INTEGER default '0' ");
    localStringBuilder.append(" idx INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "temp";
    locala.ujN.put("temp", "INTEGER default '0' ");
    localStringBuilder.append(" temp INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[19] = "source";
    locala.ujN.put("source", "INTEGER default '0' ");
    localStringBuilder.append(" source INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "needupload";
    locala.ujN.put("needupload", "INTEGER default '0' ");
    localStringBuilder.append(" needupload INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[21] = "designerID";
    locala.ujN.put("designerID", "TEXT");
    localStringBuilder.append(" designerID TEXT");
    localStringBuilder.append(", ");
    locala.columns[22] = "thumbUrl";
    locala.ujN.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[23] = "cdnUrl";
    locala.ujN.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[24] = "encrypturl";
    locala.ujN.put("encrypturl", "TEXT");
    localStringBuilder.append(" encrypturl TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "aeskey";
    locala.ujN.put("aeskey", "TEXT");
    localStringBuilder.append(" aeskey TEXT");
    localStringBuilder.append(", ");
    locala.columns[26] = "width";
    locala.ujN.put("width", "INTEGER default '0' ");
    localStringBuilder.append(" width INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[27] = "height";
    locala.ujN.put("height", "INTEGER default '0' ");
    localStringBuilder.append(" height INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[28] = "externUrl";
    locala.ujN.put("externUrl", "TEXT");
    localStringBuilder.append(" externUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[29] = "externMd5";
    locala.ujN.put("externMd5", "TEXT");
    localStringBuilder.append(" externMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[30] = "activityid";
    locala.ujN.put("activityid", "TEXT");
    localStringBuilder.append(" activityid TEXT");
    localStringBuilder.append(", ");
    locala.columns[31] = "tpurl";
    locala.ujN.put("tpurl", "TEXT");
    localStringBuilder.append(" tpurl TEXT");
    localStringBuilder.append(", ");
    locala.columns[32] = "tpauthkey";
    locala.ujN.put("tpauthkey", "TEXT");
    localStringBuilder.append(" tpauthkey TEXT");
    localStringBuilder.append(", ");
    locala.columns[33] = "wxamMd5";
    locala.ujN.put("wxamMd5", "TEXT");
    localStringBuilder.append(" wxamMd5 TEXT");
    localStringBuilder.append(", ");
    locala.columns[34] = "attachedText";
    locala.ujN.put("attachedText", "TEXT");
    localStringBuilder.append(" attachedText TEXT");
    locala.columns[35] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public EmojiInfo()
  {
    StringBuilder localStringBuilder;
    if (((h)g.DM().Dr()).Ex())
    {
      localStringBuilder = new StringBuilder();
      g.DQ();
    }
    for (this.ndA = (g.DP().dKt + "emoji/");; this.ndA = (((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().FU() + "emoji/"))
    {
      reset();
      return;
    }
  }
  
  protected EmojiInfo(Parcel paramParcel)
  {
    this.ndA = paramParcel.readString();
    this.field_md5 = paramParcel.readString();
    this.field_svrid = paramParcel.readString();
    this.field_catalog = paramParcel.readInt();
    this.field_type = paramParcel.readInt();
    this.field_size = paramParcel.readInt();
    this.field_start = paramParcel.readInt();
    this.field_state = paramParcel.readInt();
    this.field_name = paramParcel.readString();
    this.field_content = paramParcel.readString();
    this.field_reserved1 = paramParcel.readString();
    this.field_reserved2 = paramParcel.readString();
    this.field_reserved3 = paramParcel.readInt();
    this.field_reserved4 = paramParcel.readInt();
    this.field_app_id = paramParcel.readString();
    this.field_groupId = paramParcel.readString();
    this.field_lastUseTime = paramParcel.readLong();
    this.field_framesInfo = paramParcel.readString();
    this.field_idx = paramParcel.readInt();
    this.field_temp = paramParcel.readInt();
    this.field_source = paramParcel.readInt();
    this.field_needupload = paramParcel.readInt();
    this.field_designerID = paramParcel.readString();
    this.field_thumbUrl = paramParcel.readString();
    this.field_cdnUrl = paramParcel.readString();
    this.field_encrypturl = paramParcel.readString();
    this.field_aeskey = paramParcel.readString();
    this.field_width = paramParcel.readInt();
    this.field_height = paramParcel.readInt();
    this.field_activityid = paramParcel.readString();
    this.ujK = paramParcel.readLong();
    this.field_wxamMd5 = paramParcel.readString();
    this.field_attachedText = paramParcel.readString();
  }
  
  public EmojiInfo(String paramString)
  {
    this.ndA = paramString;
    reset();
  }
  
  public static boolean Fu(int paramInt)
  {
    return (paramInt == uCY) || (paramInt == uCX);
  }
  
  public static InputStream bv(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (bk.bl(paramString))) {
      return null;
    }
    try
    {
      paramString = paramString.split("\\.")[0];
      y.d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", new Object[] { paramString });
      int i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
      paramContext = paramContext.getResources().openRawResource(i);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      y.w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", new Object[] { paramContext.getMessage() });
    }
    return null;
  }
  
  public final void Fv(int paramInt)
  {
    this.field_catalog = paramInt;
  }
  
  public final String Wv()
  {
    if (this.field_md5 == null) {
      return "";
    }
    return this.field_md5;
  }
  
  public final boolean ZH()
  {
    return (this.field_catalog == uCY) || (this.field_catalog == uCX);
  }
  
  public final boolean bX(Object paramObject)
  {
    return (paramObject != null) && ((paramObject instanceof EmojiInfo)) && (((EmojiInfo)paramObject).Wv().equalsIgnoreCase(this.field_md5));
  }
  
  public final boolean bZU()
  {
    return Wv().length() == 32;
  }
  
  public final String cjB()
  {
    return this.ndA;
  }
  
  public final void cwA()
  {
    if ((this.field_catalog == uCV) || (this.field_catalog == uCY) || (this.field_catalog == uCX)) {}
    for (;;)
    {
      return;
      if (!bk.bl(this.field_groupId)) {}
      for (b localb = new b(this.ndA + this.field_groupId + "/" + Wv()); localb.exists(); localb = new b(this.ndA + Wv()))
      {
        localb.delete();
        return;
      }
    }
  }
  
  public final boolean cwB()
  {
    if ((this.field_catalog == uCV) || (this.field_catalog == uCY) || (this.field_catalog == uCX)) {
      return true;
    }
    return new b(this.ndA + this.field_groupId + "/" + Wv()).exists();
  }
  
  public final boolean cwC()
  {
    return (this.field_catalog == uCV) || (this.field_catalog == uCY) || (this.field_catalog == uCX);
  }
  
  public final boolean cwD()
  {
    return this.field_groupId.equalsIgnoreCase("com.tencent.xin.emoticon.tuzki2");
  }
  
  public final boolean cwE()
  {
    return (bk.bl(this.field_app_id)) && (!bk.bl(this.field_groupId)) && (!this.field_groupId.equals(String.valueOf(EmojiGroupInfo.uCR))) && (!this.field_groupId.equals(String.valueOf(EmojiGroupInfo.uCQ))) && (!this.field_groupId.equals(String.valueOf(EmojiGroupInfo.uCS))) && (!this.field_groupId.equals(String.valueOf(uCT)));
  }
  
  public final boolean cwF()
  {
    return !bk.bl(this.field_wxamMd5);
  }
  
  public final String cwG()
  {
    if (this.field_svrid == null) {
      return "";
    }
    return this.field_svrid;
  }
  
  public final int cwH()
  {
    return this.field_catalog;
  }
  
  public final int cwI()
  {
    return this.field_reserved4;
  }
  
  public final void cwJ()
  {
    this.field_temp = 1;
  }
  
  public final boolean cwK()
  {
    if ((this.field_catalog == uCV) || (this.field_catalog == EmojiGroupInfo.uCR) || (this.field_catalog == uCY) || (this.field_catalog == uCX)) {
      return true;
    }
    if (cwE())
    {
      String str = cwL();
      localObject = str;
      if (str == null) {
        localObject = this.ndA + this.field_groupId + "/" + Wv();
      }
    }
    for (Object localObject = new b((String)localObject); (((b)localObject).exists()) && (((b)localObject).length() > 0L); localObject = new b(this.ndA + Wv())) {
      return true;
    }
    return false;
  }
  
  public final String cwL()
  {
    if ((bk.bl(this.field_groupId)) && (bk.bl(this.field_md5))) {
      y.w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. product id and md5 are null.");
    }
    while (bk.bl(this.field_md5)) {
      return null;
    }
    if (bk.bl(this.field_groupId)) {
      return this.ndA + this.field_md5;
    }
    return this.ndA + this.field_groupId + "/" + this.field_md5;
  }
  
  public final boolean cwz()
  {
    if ((this.field_catalog == uCV) || (this.field_catalog == uCY) || (this.field_catalog == uCX)) {
      return true;
    }
    if (!bk.bl(this.field_groupId)) {}
    for (b localb = new b(this.ndA + this.field_groupId + "/" + Wv()); (localb.exists()) && (localb.length() > 0L); localb = new b(this.ndA + Wv())) {
      return true;
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return bX(paramObject);
  }
  
  /* Error */
  public final byte[] fh(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: iload_1
    //   8: iflt +11 -> 19
    //   11: iload_2
    //   12: ifge +10 -> 22
    //   15: aload 6
    //   17: astore 5
    //   19: aload 5
    //   21: areturn
    //   22: aload_0
    //   23: getfield 374	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   26: getstatic 49	com/tencent/mm/storage/emotion/EmojiInfo:uCV	I
    //   29: if_icmpeq +23 -> 52
    //   32: aload_0
    //   33: getfield 374	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   36: getstatic 55	com/tencent/mm/storage/emotion/EmojiInfo:uCY	I
    //   39: if_icmpeq +13 -> 52
    //   42: aload_0
    //   43: getfield 374	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   46: getstatic 53	com/tencent/mm/storage/emotion/EmojiInfo:uCX	I
    //   49: if_icmpne +155 -> 204
    //   52: ldc_w 487
    //   55: ldc_w 609
    //   58: iconst_1
    //   59: anewarray 491	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: invokevirtual 612	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 497	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: invokestatic 618	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   75: aload_0
    //   76: invokevirtual 612	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   79: invokestatic 620	com/tencent/mm/storage/emotion/EmojiInfo:bv	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   82: astore 6
    //   84: iload_1
    //   85: i2l
    //   86: lstore_3
    //   87: aload 6
    //   89: astore 5
    //   91: aload 6
    //   93: lload_3
    //   94: invokevirtual 626	java/io/InputStream:skip	(J)J
    //   97: pop2
    //   98: aload 6
    //   100: astore 5
    //   102: iload_2
    //   103: newarray byte
    //   105: astore 7
    //   107: aload 6
    //   109: astore 5
    //   111: aload 6
    //   113: aload 7
    //   115: iconst_0
    //   116: iload_2
    //   117: invokevirtual 630	java/io/InputStream:read	([BII)I
    //   120: pop
    //   121: aload 7
    //   123: astore 5
    //   125: aload 6
    //   127: ifnull -108 -> 19
    //   130: aload 6
    //   132: invokevirtual 633	java/io/InputStream:close	()V
    //   135: aload 7
    //   137: areturn
    //   138: astore 5
    //   140: ldc_w 487
    //   143: ldc_w 635
    //   146: iconst_1
    //   147: anewarray 491	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload 5
    //   154: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   157: aastore
    //   158: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload 7
    //   163: areturn
    //   164: astore 7
    //   166: aconst_null
    //   167: astore 6
    //   169: aload 6
    //   171: astore 5
    //   173: ldc_w 487
    //   176: ldc_w 635
    //   179: iconst_1
    //   180: anewarray 491	java/lang/Object
    //   183: dup
    //   184: iconst_0
    //   185: aload 7
    //   187: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   190: aastore
    //   191: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: aload 6
    //   196: ifnull +8 -> 204
    //   199: aload 6
    //   201: invokevirtual 633	java/io/InputStream:close	()V
    //   204: new 112	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   211: aload_0
    //   212: getfield 337	com/tencent/mm/storage/emotion/EmojiInfo:ndA	Ljava/lang/String;
    //   215: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: aload_0
    //   219: invokevirtual 536	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   222: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: astore 5
    //   230: aload_0
    //   231: invokevirtual 589	com/tencent/mm/storage/emotion/EmojiInfo:cwE	()Z
    //   234: ifeq +42 -> 276
    //   237: new 112	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   244: aload_0
    //   245: getfield 337	com/tencent/mm/storage/emotion/EmojiInfo:ndA	Ljava/lang/String;
    //   248: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_0
    //   252: getfield 410	com/tencent/mm/storage/emotion/EmojiInfo:field_groupId	Ljava/lang/String;
    //   255: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: ldc_w 549
    //   261: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_0
    //   265: invokevirtual 536	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   268: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: astore 5
    //   276: aload 5
    //   278: aload_0
    //   279: getfield 383	com/tencent/mm/storage/emotion/EmojiInfo:field_start	I
    //   282: iload_2
    //   283: invokestatic 648	com/tencent/mm/vfs/e:c	(Ljava/lang/String;II)[B
    //   286: areturn
    //   287: astore 5
    //   289: ldc_w 487
    //   292: ldc_w 635
    //   295: iconst_1
    //   296: anewarray 491	java/lang/Object
    //   299: dup
    //   300: iconst_0
    //   301: aload 5
    //   303: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   306: aastore
    //   307: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   310: goto -106 -> 204
    //   313: astore 6
    //   315: aconst_null
    //   316: astore 5
    //   318: aload 5
    //   320: ifnull +8 -> 328
    //   323: aload 5
    //   325: invokevirtual 633	java/io/InputStream:close	()V
    //   328: aload 6
    //   330: athrow
    //   331: astore 5
    //   333: ldc_w 487
    //   336: ldc_w 635
    //   339: iconst_1
    //   340: anewarray 491	java/lang/Object
    //   343: dup
    //   344: iconst_0
    //   345: aload 5
    //   347: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   350: aastore
    //   351: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   354: goto -26 -> 328
    //   357: astore 6
    //   359: goto -41 -> 318
    //   362: astore 7
    //   364: goto -195 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	EmojiInfo
    //   0	367	1	paramInt1	int
    //   0	367	2	paramInt2	int
    //   86	8	3	l	long
    //   5	119	5	localObject1	Object
    //   138	15	5	localIOException1	java.io.IOException
    //   171	106	5	localObject2	Object
    //   287	15	5	localIOException2	java.io.IOException
    //   316	8	5	localObject3	Object
    //   331	15	5	localIOException3	java.io.IOException
    //   1	199	6	localInputStream	InputStream
    //   313	16	6	localObject4	Object
    //   357	1	6	localObject5	Object
    //   105	57	7	arrayOfByte	byte[]
    //   164	22	7	localIOException4	java.io.IOException
    //   362	1	7	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   130	135	138	java/io/IOException
    //   52	84	164	java/io/IOException
    //   199	204	287	java/io/IOException
    //   52	84	313	finally
    //   323	328	331	java/io/IOException
    //   91	98	357	finally
    //   102	107	357	finally
    //   111	121	357	finally
    //   173	194	357	finally
    //   91	98	362	java/io/IOException
    //   102	107	362	java/io/IOException
    //   111	121	362	java/io/IOException
  }
  
  public final String getContent()
  {
    if (this.field_content == null) {
      return "";
    }
    return this.field_content;
  }
  
  public final String getName()
  {
    if (this.field_name == null) {
      return "";
    }
    return this.field_name;
  }
  
  public final Bitmap gl(Context paramContext)
  {
    try
    {
      paramContext = gm(paramContext);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public final Bitmap gm(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: aload_1
    //   6: bipush 120
    //   8: invokestatic 662	com/tencent/mm/cb/a:fromDPToPix	(Landroid/content/Context;I)I
    //   11: pop
    //   12: aload_0
    //   13: getfield 374	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   16: getstatic 49	com/tencent/mm/storage/emotion/EmojiInfo:uCV	I
    //   19: if_icmpeq +37 -> 56
    //   22: aload_0
    //   23: getfield 374	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   26: getstatic 568	com/tencent/mm/storage/emotion/EmojiGroupInfo:uCR	I
    //   29: if_icmpeq +27 -> 56
    //   32: aload_0
    //   33: getfield 374	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   36: getstatic 55	com/tencent/mm/storage/emotion/EmojiInfo:uCY	I
    //   39: if_icmpeq +17 -> 56
    //   42: aload_0
    //   43: getfield 374	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   46: istore_2
    //   47: getstatic 53	com/tencent/mm/storage/emotion/EmojiInfo:uCX	I
    //   50: istore_3
    //   51: iload_2
    //   52: iload_3
    //   53: if_icmpne +232 -> 285
    //   56: aload_0
    //   57: invokevirtual 612	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   60: astore 4
    //   62: aload_0
    //   63: getfield 377	com/tencent/mm/storage/emotion/EmojiInfo:field_type	I
    //   66: getstatic 65	com/tencent/mm/storage/emotion/EmojiInfo:uDb	I
    //   69: if_icmpne +19 -> 88
    //   72: aload_0
    //   73: invokevirtual 664	com/tencent/mm/storage/emotion/EmojiInfo:getContent	()Ljava/lang/String;
    //   76: invokestatic 479	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   79: ifeq +47 -> 126
    //   82: aload_0
    //   83: invokevirtual 612	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   86: astore 4
    //   88: aload_1
    //   89: aload 4
    //   91: invokestatic 620	com/tencent/mm/storage/emotion/EmojiInfo:bv	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   94: astore 4
    //   96: aload 4
    //   98: astore_1
    //   99: aload 4
    //   101: invokestatic 670	com/tencent/mm/sdk/platformtools/c:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   104: astore 5
    //   106: aload 5
    //   108: astore_1
    //   109: aload 4
    //   111: ifnull +11 -> 122
    //   114: aload 4
    //   116: invokevirtual 633	java/io/InputStream:close	()V
    //   119: aload 5
    //   121: astore_1
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_1
    //   125: areturn
    //   126: aload_0
    //   127: invokevirtual 664	com/tencent/mm/storage/emotion/EmojiInfo:getContent	()Ljava/lang/String;
    //   130: astore 4
    //   132: goto -44 -> 88
    //   135: astore_1
    //   136: ldc_w 487
    //   139: ldc_w 635
    //   142: iconst_1
    //   143: anewarray 491	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_1
    //   149: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   152: aastore
    //   153: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   156: aload 5
    //   158: astore_1
    //   159: goto -37 -> 122
    //   162: astore_1
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_1
    //   166: athrow
    //   167: astore 5
    //   169: aconst_null
    //   170: astore 4
    //   172: aload 4
    //   174: astore_1
    //   175: ldc_w 487
    //   178: ldc_w 635
    //   181: iconst_1
    //   182: anewarray 491	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload 5
    //   189: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload 4
    //   198: ifnull +82 -> 280
    //   201: aload 4
    //   203: invokevirtual 633	java/io/InputStream:close	()V
    //   206: aconst_null
    //   207: astore_1
    //   208: goto -86 -> 122
    //   211: astore_1
    //   212: ldc_w 487
    //   215: ldc_w 635
    //   218: iconst_1
    //   219: anewarray 491	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_1
    //   225: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   228: aastore
    //   229: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: aconst_null
    //   233: astore_1
    //   234: goto -112 -> 122
    //   237: astore_1
    //   238: aload 5
    //   240: astore 4
    //   242: aload 4
    //   244: ifnull +8 -> 252
    //   247: aload 4
    //   249: invokevirtual 633	java/io/InputStream:close	()V
    //   252: aload_1
    //   253: athrow
    //   254: astore 4
    //   256: ldc_w 487
    //   259: ldc_w 635
    //   262: iconst_1
    //   263: anewarray 491	java/lang/Object
    //   266: dup
    //   267: iconst_0
    //   268: aload 4
    //   270: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   273: aastore
    //   274: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: goto -25 -> 252
    //   280: aconst_null
    //   281: astore_1
    //   282: goto -160 -> 122
    //   285: aload_0
    //   286: invokevirtual 589	com/tencent/mm/storage/emotion/EmojiInfo:cwE	()Z
    //   289: ifeq +150 -> 439
    //   292: aload_0
    //   293: invokevirtual 592	com/tencent/mm/storage/emotion/EmojiInfo:cwL	()Ljava/lang/String;
    //   296: astore_1
    //   297: aload_1
    //   298: ifnonnull +841 -> 1139
    //   301: new 112	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   308: aload_0
    //   309: getfield 337	com/tencent/mm/storage/emotion/EmojiInfo:ndA	Ljava/lang/String;
    //   312: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload_0
    //   316: getfield 410	com/tencent/mm/storage/emotion/EmojiInfo:field_groupId	Ljava/lang/String;
    //   319: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: ldc_w 549
    //   325: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_0
    //   329: invokevirtual 536	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   332: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc_w 672
    //   338: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: astore_1
    //   345: new 547	com/tencent/mm/vfs/b
    //   348: dup
    //   349: aload_1
    //   350: invokespecial 551	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   353: astore_1
    //   354: aload_1
    //   355: invokevirtual 554	com/tencent/mm/vfs/b:exists	()Z
    //   358: ifeq +214 -> 572
    //   361: aload_1
    //   362: invokestatic 676	com/tencent/mm/vfs/e:o	(Lcom/tencent/mm/vfs/b;)Ljava/io/InputStream;
    //   365: astore 4
    //   367: aload 4
    //   369: astore_1
    //   370: aload 4
    //   372: astore 5
    //   374: aload 4
    //   376: astore 6
    //   378: aload 4
    //   380: invokestatic 670	com/tencent/mm/sdk/platformtools/c:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   383: astore 7
    //   385: aload 7
    //   387: astore 6
    //   389: aload 4
    //   391: astore 7
    //   393: aload 6
    //   395: astore_1
    //   396: aload 7
    //   398: ifnull -276 -> 122
    //   401: aload 7
    //   403: invokevirtual 633	java/io/InputStream:close	()V
    //   406: aload 6
    //   408: astore_1
    //   409: goto -287 -> 122
    //   412: astore_1
    //   413: ldc_w 487
    //   416: ldc_w 635
    //   419: iconst_1
    //   420: anewarray 491	java/lang/Object
    //   423: dup
    //   424: iconst_0
    //   425: aload_1
    //   426: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   429: aastore
    //   430: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   433: aload 6
    //   435: astore_1
    //   436: goto -314 -> 122
    //   439: new 547	com/tencent/mm/vfs/b
    //   442: dup
    //   443: new 112	java/lang/StringBuilder
    //   446: dup
    //   447: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   450: aload_0
    //   451: getfield 337	com/tencent/mm/storage/emotion/EmojiInfo:ndA	Ljava/lang/String;
    //   454: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_0
    //   458: invokevirtual 536	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   461: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc_w 678
    //   467: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokespecial 551	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   476: astore_1
    //   477: goto -123 -> 354
    //   480: astore 7
    //   482: aconst_null
    //   483: astore 4
    //   485: aconst_null
    //   486: astore 5
    //   488: aload 4
    //   490: astore_1
    //   491: ldc_w 487
    //   494: ldc_w 635
    //   497: iconst_1
    //   498: anewarray 491	java/lang/Object
    //   501: dup
    //   502: iconst_0
    //   503: aload 7
    //   505: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   508: aastore
    //   509: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   512: aload 4
    //   514: astore_1
    //   515: ldc_w 487
    //   518: aload 7
    //   520: invokevirtual 679	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   523: invokestatic 681	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   526: aload 5
    //   528: astore_1
    //   529: aload 4
    //   531: ifnull -409 -> 122
    //   534: aload 4
    //   536: invokevirtual 633	java/io/InputStream:close	()V
    //   539: aload 5
    //   541: astore_1
    //   542: goto -420 -> 122
    //   545: astore_1
    //   546: ldc_w 487
    //   549: ldc_w 635
    //   552: iconst_1
    //   553: anewarray 491	java/lang/Object
    //   556: dup
    //   557: iconst_0
    //   558: aload_1
    //   559: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   562: aastore
    //   563: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   566: aload 5
    //   568: astore_1
    //   569: goto -447 -> 122
    //   572: aload_0
    //   573: invokevirtual 589	com/tencent/mm/storage/emotion/EmojiInfo:cwE	()Z
    //   576: ifeq +256 -> 832
    //   579: getstatic 686	android/os/Build$VERSION:SDK_INT	I
    //   582: bipush 19
    //   584: if_icmpge +546 -> 1130
    //   587: new 112	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   594: aload_0
    //   595: getfield 337	com/tencent/mm/storage/emotion/EmojiInfo:ndA	Ljava/lang/String;
    //   598: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: aload_0
    //   602: getfield 410	com/tencent/mm/storage/emotion/EmojiInfo:field_groupId	Ljava/lang/String;
    //   605: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: ldc_w 549
    //   611: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload_0
    //   615: invokevirtual 536	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   618: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 690	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   627: astore 4
    //   629: aload 4
    //   631: astore_1
    //   632: aload 4
    //   634: astore 5
    //   636: aload 4
    //   638: astore 6
    //   640: aload 4
    //   642: invokestatic 670	com/tencent/mm/sdk/platformtools/c:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   645: astore 7
    //   647: aload 7
    //   649: astore 5
    //   651: aload 4
    //   653: astore_1
    //   654: aload_0
    //   655: invokevirtual 589	com/tencent/mm/storage/emotion/EmojiInfo:cwE	()Z
    //   658: ifeq +228 -> 886
    //   661: aload 4
    //   663: astore_1
    //   664: ldc_w 487
    //   667: ldc_w 692
    //   670: invokestatic 694	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: aload 5
    //   675: astore 6
    //   677: aload 4
    //   679: astore 7
    //   681: aload 4
    //   683: astore_1
    //   684: new 547	com/tencent/mm/vfs/b
    //   687: dup
    //   688: new 112	java/lang/StringBuilder
    //   691: dup
    //   692: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   695: aload_0
    //   696: getfield 337	com/tencent/mm/storage/emotion/EmojiInfo:ndA	Ljava/lang/String;
    //   699: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload_0
    //   703: getfield 410	com/tencent/mm/storage/emotion/EmojiInfo:field_groupId	Ljava/lang/String;
    //   706: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: ldc_w 549
    //   712: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload_0
    //   716: invokevirtual 536	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   719: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: ldc_w 696
    //   725: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: invokespecial 551	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   734: invokevirtual 554	com/tencent/mm/vfs/b:exists	()Z
    //   737: ifne -344 -> 393
    //   740: aload 5
    //   742: astore 6
    //   744: aload 4
    //   746: astore 7
    //   748: aload 4
    //   750: astore_1
    //   751: getstatic 686	android/os/Build$VERSION:SDK_INT	I
    //   754: bipush 19
    //   756: if_icmpge -363 -> 393
    //   759: aload 4
    //   761: astore_1
    //   762: aload 5
    //   764: bipush 100
    //   766: getstatic 702	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   769: new 112	java/lang/StringBuilder
    //   772: dup
    //   773: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   776: aload_0
    //   777: getfield 337	com/tencent/mm/storage/emotion/EmojiInfo:ndA	Ljava/lang/String;
    //   780: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_0
    //   784: getfield 410	com/tencent/mm/storage/emotion/EmojiInfo:field_groupId	Ljava/lang/String;
    //   787: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: ldc_w 549
    //   793: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: aload_0
    //   797: invokevirtual 536	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   800: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: ldc_w 696
    //   806: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: iconst_0
    //   813: invokestatic 706	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   816: aload 5
    //   818: astore 6
    //   820: aload 4
    //   822: astore 7
    //   824: goto -431 -> 393
    //   827: astore 7
    //   829: goto -341 -> 488
    //   832: new 112	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   839: aload_0
    //   840: getfield 337	com/tencent/mm/storage/emotion/EmojiInfo:ndA	Ljava/lang/String;
    //   843: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: aload_0
    //   847: invokevirtual 536	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   850: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   856: invokestatic 690	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   859: astore 4
    //   861: aload 4
    //   863: astore_1
    //   864: aload 4
    //   866: astore 5
    //   868: aload 4
    //   870: astore 6
    //   872: aload 4
    //   874: invokestatic 670	com/tencent/mm/sdk/platformtools/c:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   877: astore 7
    //   879: aload 7
    //   881: astore 5
    //   883: goto -232 -> 651
    //   886: aload 4
    //   888: astore_1
    //   889: aload 5
    //   891: bipush 100
    //   893: getstatic 702	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   896: new 112	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   903: aload_0
    //   904: getfield 337	com/tencent/mm/storage/emotion/EmojiInfo:ndA	Ljava/lang/String;
    //   907: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: aload_0
    //   911: invokevirtual 536	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   914: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: ldc_w 678
    //   920: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: invokevirtual 290	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: iconst_0
    //   927: invokestatic 706	com/tencent/mm/sdk/platformtools/c:a	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)V
    //   930: aload 5
    //   932: astore 6
    //   934: aload 4
    //   936: astore 7
    //   938: goto -545 -> 393
    //   941: astore 7
    //   943: aload 4
    //   945: astore 6
    //   947: aload 5
    //   949: astore 4
    //   951: aload 6
    //   953: astore_1
    //   954: ldc_w 487
    //   957: ldc_w 635
    //   960: iconst_1
    //   961: anewarray 491	java/lang/Object
    //   964: dup
    //   965: iconst_0
    //   966: aload 7
    //   968: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   971: aastore
    //   972: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   975: aload 6
    //   977: astore_1
    //   978: ldc_w 487
    //   981: aload 7
    //   983: invokevirtual 523	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   986: invokestatic 681	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   989: aload 4
    //   991: astore_1
    //   992: aload 6
    //   994: ifnull -872 -> 122
    //   997: aload 6
    //   999: invokevirtual 633	java/io/InputStream:close	()V
    //   1002: aload 4
    //   1004: astore_1
    //   1005: goto -883 -> 122
    //   1008: astore_1
    //   1009: ldc_w 487
    //   1012: ldc_w 635
    //   1015: iconst_1
    //   1016: anewarray 491	java/lang/Object
    //   1019: dup
    //   1020: iconst_0
    //   1021: aload_1
    //   1022: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1025: aastore
    //   1026: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1029: aload 4
    //   1031: astore_1
    //   1032: goto -910 -> 122
    //   1035: astore 4
    //   1037: aconst_null
    //   1038: astore_1
    //   1039: aload_1
    //   1040: ifnull +7 -> 1047
    //   1043: aload_1
    //   1044: invokevirtual 633	java/io/InputStream:close	()V
    //   1047: aload 4
    //   1049: athrow
    //   1050: astore_1
    //   1051: ldc_w 487
    //   1054: ldc_w 635
    //   1057: iconst_1
    //   1058: anewarray 491	java/lang/Object
    //   1061: dup
    //   1062: iconst_0
    //   1063: aload_1
    //   1064: invokestatic 639	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1067: aastore
    //   1068: invokestatic 642	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1071: goto -24 -> 1047
    //   1074: astore 4
    //   1076: goto -37 -> 1039
    //   1079: astore 7
    //   1081: aconst_null
    //   1082: astore 6
    //   1084: aconst_null
    //   1085: astore 4
    //   1087: goto -136 -> 951
    //   1090: astore 7
    //   1092: aconst_null
    //   1093: astore 4
    //   1095: aload 5
    //   1097: astore 6
    //   1099: goto -148 -> 951
    //   1102: astore 7
    //   1104: aconst_null
    //   1105: astore 5
    //   1107: aload 6
    //   1109: astore 4
    //   1111: goto -623 -> 488
    //   1114: astore 5
    //   1116: aload_1
    //   1117: astore 4
    //   1119: aload 5
    //   1121: astore_1
    //   1122: goto -880 -> 242
    //   1125: astore 5
    //   1127: goto -955 -> 172
    //   1130: aconst_null
    //   1131: astore 4
    //   1133: aconst_null
    //   1134: astore 5
    //   1136: goto -485 -> 651
    //   1139: goto -794 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1142	0	this	EmojiInfo
    //   0	1142	1	paramContext	Context
    //   46	8	2	i	int
    //   50	4	3	j	int
    //   60	188	4	localObject1	Object
    //   254	15	4	localIOException	java.io.IOException
    //   365	665	4	localObject2	Object
    //   1035	13	4	localObject3	Object
    //   1074	1	4	localObject4	Object
    //   1085	47	4	localObject5	Object
    //   1	156	5	localBitmap	Bitmap
    //   167	72	5	localException1	Exception
    //   372	734	5	localObject6	Object
    //   1114	6	5	localObject7	Object
    //   1125	1	5	localException2	Exception
    //   1134	1	5	localObject8	Object
    //   376	732	6	localObject9	Object
    //   383	19	7	localObject10	Object
    //   480	39	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   645	178	7	localObject11	Object
    //   827	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    //   877	60	7	localObject12	Object
    //   941	41	7	localException3	Exception
    //   1079	1	7	localException4	Exception
    //   1090	1	7	localException5	Exception
    //   1102	1	7	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   114	119	135	java/io/IOException
    //   5	51	162	finally
    //   114	119	162	finally
    //   136	156	162	finally
    //   201	206	162	finally
    //   212	232	162	finally
    //   247	252	162	finally
    //   252	254	162	finally
    //   256	277	162	finally
    //   401	406	162	finally
    //   413	433	162	finally
    //   534	539	162	finally
    //   546	566	162	finally
    //   997	1002	162	finally
    //   1009	1029	162	finally
    //   1043	1047	162	finally
    //   1047	1050	162	finally
    //   1051	1071	162	finally
    //   56	62	167	java/lang/Exception
    //   62	88	167	java/lang/Exception
    //   88	96	167	java/lang/Exception
    //   126	132	167	java/lang/Exception
    //   201	206	211	java/io/IOException
    //   56	62	237	finally
    //   62	88	237	finally
    //   88	96	237	finally
    //   126	132	237	finally
    //   247	252	254	java/io/IOException
    //   401	406	412	java/io/IOException
    //   285	297	480	java/io/FileNotFoundException
    //   301	345	480	java/io/FileNotFoundException
    //   345	354	480	java/io/FileNotFoundException
    //   354	367	480	java/io/FileNotFoundException
    //   439	477	480	java/io/FileNotFoundException
    //   572	629	480	java/io/FileNotFoundException
    //   832	861	480	java/io/FileNotFoundException
    //   534	539	545	java/io/IOException
    //   654	661	827	java/io/FileNotFoundException
    //   664	673	827	java/io/FileNotFoundException
    //   684	740	827	java/io/FileNotFoundException
    //   751	759	827	java/io/FileNotFoundException
    //   762	816	827	java/io/FileNotFoundException
    //   889	930	827	java/io/FileNotFoundException
    //   654	661	941	java/lang/Exception
    //   664	673	941	java/lang/Exception
    //   684	740	941	java/lang/Exception
    //   751	759	941	java/lang/Exception
    //   762	816	941	java/lang/Exception
    //   889	930	941	java/lang/Exception
    //   997	1002	1008	java/io/IOException
    //   285	297	1035	finally
    //   301	345	1035	finally
    //   345	354	1035	finally
    //   354	367	1035	finally
    //   439	477	1035	finally
    //   572	629	1035	finally
    //   832	861	1035	finally
    //   1043	1047	1050	java/io/IOException
    //   378	385	1074	finally
    //   491	512	1074	finally
    //   515	526	1074	finally
    //   640	647	1074	finally
    //   654	661	1074	finally
    //   664	673	1074	finally
    //   684	740	1074	finally
    //   751	759	1074	finally
    //   762	816	1074	finally
    //   872	879	1074	finally
    //   889	930	1074	finally
    //   954	975	1074	finally
    //   978	989	1074	finally
    //   285	297	1079	java/lang/Exception
    //   301	345	1079	java/lang/Exception
    //   345	354	1079	java/lang/Exception
    //   354	367	1079	java/lang/Exception
    //   439	477	1079	java/lang/Exception
    //   572	629	1079	java/lang/Exception
    //   832	861	1079	java/lang/Exception
    //   378	385	1090	java/lang/Exception
    //   640	647	1090	java/lang/Exception
    //   872	879	1090	java/lang/Exception
    //   378	385	1102	java/io/FileNotFoundException
    //   640	647	1102	java/io/FileNotFoundException
    //   872	879	1102	java/io/FileNotFoundException
    //   99	106	1114	finally
    //   175	196	1114	finally
    //   99	106	1125	java/lang/Exception
  }
  
  public final boolean isGif()
  {
    return (this.field_type == uDb) || (this.field_type == uDd);
  }
  
  public final void pG(String paramString)
  {
    this.field_md5 = paramString;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final void reset()
  {
    this.field_md5 = "";
    this.field_svrid = "";
    this.field_catalog = uCV;
    this.field_type = uDa;
    this.field_size = 0;
    this.field_start = 0;
    this.field_state = uDf;
    this.field_name = "";
    this.field_content = "";
    this.field_reserved1 = "";
    this.field_reserved2 = "";
    this.field_reserved3 = 0;
    this.field_reserved4 = 0;
    this.field_app_id = "";
    this.field_temp = 0;
  }
  
  public final void setSize(int paramInt)
  {
    this.field_size = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
  }
  
  public final Bitmap t(Context paramContext, int paramInt)
  {
    for (;;)
    {
      try
      {
        if ((this.field_catalog == EmojiGroupInfo.uCR) || (this.field_catalog == uCY) || (this.field_catalog == uCX))
        {
          localObject = getName();
          if (!bk.bl((String)localObject))
          {
            if (((String)localObject).startsWith("jsb"))
            {
              localObject = "jsb";
              paramInt = paramContext.getResources().getIdentifier((String)localObject, "drawable", ae.getPackageName());
              paramContext = c.q(paramContext.getResources().getDrawable(paramInt));
              y.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(this.field_catalog), Integer.valueOf(paramContext.getWidth()), Integer.valueOf(paramContext.getHeight()) });
              return paramContext;
            }
            if (((String)localObject).startsWith("dice"))
            {
              localObject = "dice";
              continue;
            }
            localObject = ((String)localObject).replaceAll(".png", "");
            continue;
          }
          y.i("MicroMsg.emoji.EmojiInfo", "name is null");
          y.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", new Object[] { this });
          paramContext = null;
          continue;
        }
        if (this.field_catalog != EmojiGroupInfo.uCQ) {
          break label374;
        }
        localObject = getName();
        if (bk.bl((String)localObject)) {
          break label362;
        }
        if (bk.bl(getContent()))
        {
          localObject = getName();
          localObject = ((String)localObject).replaceAll(".png", "");
          y.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] drawable name:%s", new Object[] { localObject });
          paramInt = paramContext.getResources().getIdentifier((String)localObject, "drawable", ae.getPackageName());
          paramContext = c.q(paramContext.getResources().getDrawable(paramInt));
          y.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(this.field_catalog), Integer.valueOf(paramContext.getWidth()), Integer.valueOf(paramContext.getHeight()) });
          continue;
        }
        localObject = getContent();
      }
      finally {}
      continue;
      label362:
      y.i("MicroMsg.emoji.EmojiInfo", "name is null");
      continue;
      label374:
      paramContext = cwL() + "_cover";
      boolean bool = com.tencent.mm.vfs.e.bK(paramContext);
      y.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] thumbPath:%s isExist:%s", new Object[] { paramContext, Boolean.valueOf(bool) });
      if (bool) {
        break;
      }
      paramContext = cwL();
      bool = com.tencent.mm.vfs.e.bK(paramContext);
      if (bool)
      {
        paramContext = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getProvider().a(this);
        if (paramContext == null)
        {
          y.e("MicroMsg.emoji.EmojiInfo", "bytes is null!");
          paramContext = null;
        }
        else
        {
          y.i("MicroMsg.emoji.EmojiInfo", "bytes size:%s", new Object[] { Integer.valueOf(paramContext.length) });
          if (o.bz(paramContext)) {}
          for (localObject = i.az(paramContext);; localObject = c.decodeByteArray(paramContext, paramInt, paramInt))
          {
            paramContext = (Context)localObject;
            if (localObject == null) {
              break;
            }
            y.i("MicroMsg.emoji.EmojiInfo", "emoji:%s width:%s height:%s", new Object[] { this, Integer.valueOf(((Bitmap)localObject).getWidth()), Integer.valueOf(((Bitmap)localObject).getHeight()) });
            paramContext = (Context)localObject;
            break;
          }
        }
      }
      else
      {
        y.w("MicroMsg.emoji.EmojiInfo", "[addEmoji] Path:%s isExist:%s", new Object[] { paramContext, Boolean.valueOf(bool) });
      }
    }
    Object localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramContext, (BitmapFactory.Options)localObject);
    label670:
    int j;
    if ((((BitmapFactory.Options)localObject).outHeight < paramInt) && (((BitmapFactory.Options)localObject).outWidth < paramInt))
    {
      paramContext = c.aj(paramContext, ((BitmapFactory.Options)localObject).outHeight, ((BitmapFactory.Options)localObject).outWidth);
      j = this.field_catalog;
      if (paramContext != null) {
        break label736;
      }
      paramInt = 0;
      label682:
      if (paramContext != null) {
        break label744;
      }
    }
    label736:
    label744:
    for (int i = 0;; i = paramContext.getHeight())
    {
      y.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(i) });
      break;
      paramContext = c.aj(paramContext, paramInt, paramInt);
      break label670;
      paramInt = paramContext.getWidth();
      break label682;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("field_md5:").append(this.field_md5).append("\n");
    localStringBuilder.append("field_svrid:").append(this.field_svrid).append("\n");
    localStringBuilder.append("field_catalog:").append(this.field_catalog).append("\n");
    localStringBuilder.append("field_type:").append(this.field_type).append("\n");
    localStringBuilder.append("field_size:").append(this.field_size).append("\n");
    localStringBuilder.append("field_start:").append(this.field_start).append("\n");
    localStringBuilder.append("field_state:").append(this.field_state).append("\n");
    localStringBuilder.append("field_name:").append(this.field_name).append("\n");
    localStringBuilder.append("field_content:").append(this.field_content).append("\n");
    localStringBuilder.append("field_reserved1:").append(this.field_reserved1).append("\n");
    localStringBuilder.append("field_reserved2:").append(this.field_reserved2).append("\n");
    localStringBuilder.append("field_reserved3:").append(this.field_reserved3).append("\n");
    localStringBuilder.append("field_reserved4:").append(this.field_reserved4).append("\n");
    localStringBuilder.append("field_app_id:").append(this.field_app_id).append("\n");
    localStringBuilder.append("field_groupId:").append(this.field_groupId).append("\n");
    localStringBuilder.append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
    localStringBuilder.append("field_framesInfo:").append(this.field_framesInfo).append("\n");
    localStringBuilder.append("field_idx:").append(this.field_idx).append("\n");
    localStringBuilder.append("field_temp:").append(this.field_temp).append("\n");
    localStringBuilder.append("field_source:").append(this.field_source).append("\n");
    localStringBuilder.append("field_needupload:").append(this.field_needupload).append("\n");
    localStringBuilder.append("field_designerID:").append(this.field_designerID).append("\n");
    localStringBuilder.append("field_thumbUrl:").append(this.field_thumbUrl).append("\n");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.ndA);
    paramParcel.writeString(this.field_md5);
    paramParcel.writeString(this.field_svrid);
    paramParcel.writeInt(this.field_catalog);
    paramParcel.writeInt(this.field_type);
    paramParcel.writeInt(this.field_size);
    paramParcel.writeInt(this.field_start);
    paramParcel.writeInt(this.field_state);
    paramParcel.writeString(this.field_name);
    paramParcel.writeString(this.field_content);
    paramParcel.writeString(this.field_reserved1);
    paramParcel.writeString(this.field_reserved2);
    paramParcel.writeInt(this.field_reserved3);
    paramParcel.writeInt(this.field_reserved4);
    paramParcel.writeString(this.field_app_id);
    paramParcel.writeString(this.field_groupId);
    paramParcel.writeLong(this.field_lastUseTime);
    paramParcel.writeString(this.field_framesInfo);
    paramParcel.writeInt(this.field_idx);
    paramParcel.writeInt(this.field_temp);
    paramParcel.writeInt(this.field_source);
    paramParcel.writeInt(this.field_needupload);
    paramParcel.writeString(this.field_designerID);
    paramParcel.writeString(this.field_thumbUrl);
    paramParcel.writeString(this.field_cdnUrl);
    paramParcel.writeString(this.field_encrypturl);
    paramParcel.writeString(this.field_aeskey);
    paramParcel.writeInt(this.field_width);
    paramParcel.writeInt(this.field_height);
    paramParcel.writeString(this.field_activityid);
    paramParcel.writeLong(this.ujK);
    paramParcel.writeString(this.field_wxamMd5);
    paramParcel.writeString(this.field_attachedText);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.EmojiInfo
 * JD-Core Version:    0.7.0.1
 */