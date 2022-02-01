package com.tencent.mm.storage.emotion;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.r;
import com.tencent.mm.emoji.e.a;
import com.tencent.mm.f.c.bj;
import com.tencent.mm.graphics.MMBitmapFactory;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.pluginsdk.b.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Map;

public class EmojiInfo
  extends bj
  implements Parcelable, r
{
  public static final Parcelable.Creator<EmojiInfo> CREATOR;
  public static int TYPE_TEXT;
  public static int YCA;
  public static int YCB;
  public static int YCC;
  public static int YCD;
  public static int YCE;
  public static int YCF;
  public static int YCt;
  public static int YCx;
  public static String YCy;
  public static int YCz;
  public static int ZuA;
  public static int ZuB;
  public static int ZuC;
  public static int ZuD;
  public static int ZuE;
  public static int ZuF;
  public static int ZuG;
  public static int ZuH;
  public static int ZuI;
  public static int ZuJ;
  public static int ZuK;
  public static int ZuL;
  public static int ZuM;
  protected static IAutoDBItem.MAutoDBInfo info;
  private final String HlQ;
  public String UaI;
  public String ZuN;
  public int ZuO;
  public int ZuP;
  public String talker;
  
  static
  {
    AppMethodBeat.i(105048);
    YCy = ".gif";
    YCz = 17;
    YCA = 32;
    YCB = 49;
    YCC = 50;
    YCx = 65;
    YCD = 81;
    YCt = -1;
    YCE = 1;
    YCF = 2;
    ZuA = 3;
    TYPE_TEXT = 4;
    ZuB = 10;
    ZuC = 11;
    ZuD = 0;
    ZuE = 1;
    ZuF = 3;
    ZuG = 4;
    ZuH = 8;
    ZuI = 0;
    ZuJ = 1;
    ZuK = 0;
    ZuL = 1;
    ZuM = 1;
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[46];
    localMAutoDBInfo.columns = new String[47];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "md5";
    localMAutoDBInfo.colsMap.put("md5", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" md5 TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "md5";
    localMAutoDBInfo.columns[1] = "svrid";
    localMAutoDBInfo.colsMap.put("svrid", "TEXT");
    localStringBuilder.append(" svrid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "catalog";
    localMAutoDBInfo.colsMap.put("catalog", "INTEGER");
    localStringBuilder.append(" catalog INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "size";
    localMAutoDBInfo.colsMap.put("size", "INTEGER");
    localStringBuilder.append(" size INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "start";
    localMAutoDBInfo.colsMap.put("start", "INTEGER");
    localStringBuilder.append(" start INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "name";
    localMAutoDBInfo.colsMap.put("name", "TEXT");
    localStringBuilder.append(" name TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "reserved1";
    localMAutoDBInfo.colsMap.put("reserved1", "TEXT");
    localStringBuilder.append(" reserved1 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "reserved2";
    localMAutoDBInfo.colsMap.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "reserved3";
    localMAutoDBInfo.colsMap.put("reserved3", "INTEGER");
    localStringBuilder.append(" reserved3 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "reserved4";
    localMAutoDBInfo.colsMap.put("reserved4", "INTEGER");
    localStringBuilder.append(" reserved4 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "app_id";
    localMAutoDBInfo.colsMap.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "groupId";
    localMAutoDBInfo.colsMap.put("groupId", "TEXT default '' ");
    localStringBuilder.append(" groupId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "lastUseTime";
    localMAutoDBInfo.colsMap.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "framesInfo";
    localMAutoDBInfo.colsMap.put("framesInfo", "TEXT default '' ");
    localStringBuilder.append(" framesInfo TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "idx";
    localMAutoDBInfo.colsMap.put("idx", "INTEGER default '0' ");
    localStringBuilder.append(" idx INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "temp";
    localMAutoDBInfo.colsMap.put("temp", "INTEGER default '0' ");
    localStringBuilder.append(" temp INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "source";
    localMAutoDBInfo.colsMap.put("source", "INTEGER default '0' ");
    localStringBuilder.append(" source INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "needupload";
    localMAutoDBInfo.colsMap.put("needupload", "INTEGER default '0' ");
    localStringBuilder.append(" needupload INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "designerID";
    localMAutoDBInfo.colsMap.put("designerID", "TEXT");
    localStringBuilder.append(" designerID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "thumbUrl";
    localMAutoDBInfo.colsMap.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "cdnUrl";
    localMAutoDBInfo.colsMap.put("cdnUrl", "TEXT");
    localStringBuilder.append(" cdnUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "encrypturl";
    localMAutoDBInfo.colsMap.put("encrypturl", "TEXT");
    localStringBuilder.append(" encrypturl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "aeskey";
    localMAutoDBInfo.colsMap.put("aeskey", "TEXT");
    localStringBuilder.append(" aeskey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "width";
    localMAutoDBInfo.colsMap.put("width", "INTEGER default '0' ");
    localStringBuilder.append(" width INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "height";
    localMAutoDBInfo.colsMap.put("height", "INTEGER default '0' ");
    localStringBuilder.append(" height INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "externUrl";
    localMAutoDBInfo.colsMap.put("externUrl", "TEXT");
    localStringBuilder.append(" externUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "externMd5";
    localMAutoDBInfo.colsMap.put("externMd5", "TEXT");
    localStringBuilder.append(" externMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[30] = "activityid";
    localMAutoDBInfo.colsMap.put("activityid", "TEXT");
    localStringBuilder.append(" activityid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[31] = "tpurl";
    localMAutoDBInfo.colsMap.put("tpurl", "TEXT");
    localStringBuilder.append(" tpurl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[32] = "tpauthkey";
    localMAutoDBInfo.colsMap.put("tpauthkey", "TEXT");
    localStringBuilder.append(" tpauthkey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[33] = "wxamMd5";
    localMAutoDBInfo.colsMap.put("wxamMd5", "TEXT");
    localStringBuilder.append(" wxamMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[34] = "attachedText";
    localMAutoDBInfo.colsMap.put("attachedText", "TEXT");
    localStringBuilder.append(" attachedText TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[35] = "captureStatus";
    localMAutoDBInfo.colsMap.put("captureStatus", "INTEGER default '0' ");
    localStringBuilder.append(" captureStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[36] = "attachedEmojiMD5";
    localMAutoDBInfo.colsMap.put("attachedEmojiMD5", "BLOB default '' ");
    localStringBuilder.append(" attachedEmojiMD5 BLOB default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[37] = "imitateMd5";
    localMAutoDBInfo.colsMap.put("imitateMd5", "TEXT");
    localStringBuilder.append(" imitateMd5 TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[38] = "captureUploadErrCode";
    localMAutoDBInfo.colsMap.put("captureUploadErrCode", "INTEGER default '0' ");
    localStringBuilder.append(" captureUploadErrCode INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[39] = "captureUploadCounter";
    localMAutoDBInfo.colsMap.put("captureUploadCounter", "INTEGER default '0' ");
    localStringBuilder.append(" captureUploadCounter INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[40] = "captureEnterTime";
    localMAutoDBInfo.colsMap.put("captureEnterTime", "LONG");
    localStringBuilder.append(" captureEnterTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[41] = "lensId";
    localMAutoDBInfo.colsMap.put("lensId", "TEXT");
    localStringBuilder.append(" lensId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[42] = "attachTextColor";
    localMAutoDBInfo.colsMap.put("attachTextColor", "TEXT");
    localStringBuilder.append(" attachTextColor TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[43] = "captureScene";
    localMAutoDBInfo.colsMap.put("captureScene", "INTEGER");
    localStringBuilder.append(" captureScene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[44] = "attr";
    localMAutoDBInfo.colsMap.put("attr", "TEXT");
    localStringBuilder.append(" attr TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[45] = "linkId";
    localMAutoDBInfo.colsMap.put("linkId", "TEXT");
    localStringBuilder.append(" linkId TEXT");
    localMAutoDBInfo.columns[46] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(105048);
  }
  
  public EmojiInfo()
  {
    AppMethodBeat.i(105022);
    this.ZuP = 2;
    a locala = a.jPz;
    this.HlQ = a.aDB();
    reset();
    AppMethodBeat.o(105022);
  }
  
  protected EmojiInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(105047);
    this.ZuP = 2;
    this.HlQ = paramParcel.readString();
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
    this.systemRowid = paramParcel.readLong();
    this.field_wxamMd5 = paramParcel.readString();
    this.field_attachedText = paramParcel.readString();
    this.field_captureStatus = paramParcel.readInt();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.field_attachedEmojiMD5 = new byte[i];
      paramParcel.readByteArray(this.field_attachedEmojiMD5);
    }
    this.field_imitateMd5 = paramParcel.readString();
    this.field_captureUploadErrCode = paramParcel.readInt();
    this.field_captureUploadCounter = paramParcel.readInt();
    this.field_captureEnterTime = paramParcel.readLong();
    this.field_lensId = paramParcel.readString();
    this.field_attachTextColor = paramParcel.readString();
    this.field_captureScene = paramParcel.readInt();
    this.field_externMd5 = paramParcel.readString();
    AppMethodBeat.o(105047);
  }
  
  public EmojiInfo(String paramString)
  {
    AppMethodBeat.i(105023);
    this.ZuP = 2;
    this.HlQ = paramString;
    reset();
    AppMethodBeat.o(105023);
  }
  
  public static boolean aAA(int paramInt)
  {
    return (paramInt == YCC) || (paramInt == YCB);
  }
  
  public static InputStream cH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(105028);
    if ((paramContext == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(105028);
      return null;
    }
    try
    {
      paramString = paramString.split("\\.")[0];
      Log.d("MicroMsg.emoji.EmojiInfo", "emoji drawable name is %s", new Object[] { paramString });
      int i = paramContext.getResources().getIdentifier(paramString, "drawable", paramContext.getPackageName());
      paramContext = paramContext.getResources().openRawResource(i);
      AppMethodBeat.o(105028);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.w("MicroMsg.emoji.EmojiInfo", "get emoji file fail, %s", new Object[] { paramContext.getMessage() });
      AppMethodBeat.o(105028);
    }
    return null;
  }
  
  public static String ifj()
  {
    AppMethodBeat.i(105042);
    Object localObject = a.jPz;
    localObject = a.aDB();
    AppMethodBeat.o(105042);
    return localObject;
  }
  
  public final Bitmap C(Context paramContext, int paramInt)
  {
    Object localObject = null;
    int[] arrayOfInt1 = null;
    int i = 0;
    try
    {
      AppMethodBeat.i(105030);
      if ((this.field_catalog == EmojiGroupInfo.YCv) || (this.field_catalog == YCC) || (this.field_catalog == YCB))
      {
        localObject = getName();
        if (!Util.isNullOrNil((String)localObject))
        {
          Log.i("MicroMsg.emoji.EmojiInfo", "#getBitmap, name = ".concat(String.valueOf(localObject)));
          if (((String)localObject).startsWith("jsb")) {
            localObject = "jsb";
          }
          for (;;)
          {
            try
            {
              paramInt = paramContext.getResources().getIdentifier((String)localObject, "drawable", paramContext.getPackageName());
              Log.i("MicroMsg.emoji.EmojiInfo", "#getBitmap, get res identifier, name = " + (String)localObject + ", resId = " + paramInt);
              paramContext = BitmapUtil.transformDrawableToBitmap(paramContext.getResources().getDrawable(paramInt));
              Log.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(this.field_catalog), Integer.valueOf(paramContext.getWidth()), Integer.valueOf(paramContext.getHeight()) });
              AppMethodBeat.o(105030);
            }
            catch (Resources.NotFoundException paramContext)
            {
              Log.printErrStackTrace("MicroMsg.emoji.EmojiInfo", paramContext, "get res fail, name = ".concat(String.valueOf(localObject)), new Object[0]);
              AppMethodBeat.o(105030);
              paramContext = arrayOfInt1;
              continue;
            }
            return paramContext;
            if (((String)localObject).startsWith("dice")) {
              localObject = "dice";
            } else {
              localObject = ((String)localObject).replaceAll(".png", "");
            }
          }
        }
        Log.i("MicroMsg.emoji.EmojiInfo", "name is null");
      }
    }
    finally {}
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiInfo", "emoji:%s", new Object[] { this });
      AppMethodBeat.o(105030);
      paramContext = arrayOfInt1;
      break;
      if (this.field_catalog == EmojiGroupInfo.YCu)
      {
        localObject = getName();
        if (!Util.isNullOrNil((String)localObject)) {
          if (Util.isNullOrNil(getContent()))
          {
            localObject = getName();
            label362:
            localObject = ((String)localObject).replaceAll(".png", "");
          }
        }
        for (;;)
        {
          Log.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] drawable name:%s", new Object[] { localObject });
          paramInt = paramContext.getResources().getIdentifier((String)localObject, "drawable", MMApplicationContext.getPackageName());
          paramContext = BitmapUtil.transformDrawableToBitmap(paramContext.getResources().getDrawable(paramInt));
          Log.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(this.field_catalog), Integer.valueOf(paramContext.getWidth()), Integer.valueOf(paramContext.getHeight()) });
          AppMethodBeat.o(105030);
          break;
          localObject = getContent();
          break label362;
          Log.i("MicroMsg.emoji.EmojiInfo", "name is null");
        }
      }
      paramContext = ifi();
      boolean bool = u.agG(paramContext);
      Log.i("MicroMsg.emoji.EmojiInfo", "[addEmoji] thumbPath:%s isExist:%s", new Object[] { paramContext, Boolean.valueOf(bool) });
      if (bool) {
        break label875;
      }
      paramContext = ifh();
      bool = u.agG(paramContext);
      if (bool)
      {
        paramContext = ((d)h.ag(d.class)).getProvider().a(this);
        if (paramContext == null)
        {
          Log.e("MicroMsg.emoji.EmojiInfo", "bytes is null!");
          AppMethodBeat.o(105030);
          paramContext = arrayOfInt1;
          break;
        }
        Log.i("MicroMsg.emoji.EmojiInfo", "bytes size:%s", new Object[] { Integer.valueOf(paramContext.length) });
        if (ImgUtil.isWXGF(paramContext)) {
          if (Util.isNullOrNil(paramContext)) {
            paramContext = (Context)localObject;
          }
        }
        for (;;)
        {
          if (paramContext != null) {
            Log.i("MicroMsg.emoji.EmojiInfo", "emoji:%s width:%s height:%s", new Object[] { this, Integer.valueOf(paramContext.getWidth()), Integer.valueOf(paramContext.getHeight()) });
          }
          AppMethodBeat.o(105030);
          break;
          int[] arrayOfInt2 = new int[4];
          arrayOfInt1 = new int[4];
          long l = MMWXGFJNI.nativeInitWxAMDecoder();
          if (l == 0L) {
            Log.w("MicroMsg.GIF.MMWXGFUtil", "Cpan init wxam decoder failed.");
          }
          paramInt = MMWXGFJNI.nativeDecodeBufferHeader(l, paramContext, paramContext.length);
          if (paramInt != 0) {
            Log.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF decode buffer header failed. result:%d", new Object[] { Integer.valueOf(paramInt) });
          }
          paramInt = MMWXGFJNI.nativeGetOption(l, paramContext, paramContext.length, arrayOfInt2);
          if (paramInt != 0) {
            Log.w("MicroMsg.GIF.MMWXGFUtil", "Cpan WXGF get option failed. result:%d", new Object[] { Integer.valueOf(paramInt) });
          }
          paramInt = arrayOfInt2[1];
          i = arrayOfInt2[2];
          paramContext = (Context)localObject;
          if (paramInt > 0)
          {
            paramContext = (Context)localObject;
            if (i > 0)
            {
              paramContext = Bitmap.createBitmap(paramInt, i, Bitmap.Config.ARGB_8888);
              MMWXGFJNI.nativeDecodeBufferFrame(l, null, 0, paramContext, arrayOfInt1);
              MMWXGFJNI.nativeUninit(l);
              continue;
              paramContext = BitmapUtil.decodeByteArray(paramContext, paramInt, paramInt);
            }
          }
        }
      }
      Log.w("MicroMsg.emoji.EmojiInfo", "[addEmoji] Path:%s isExist:%s", new Object[] { paramContext, Boolean.valueOf(bool) });
    }
    label875:
    localObject = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
    MMBitmapFactory.decodeFile(paramContext, (BitmapFactory.Options)localObject);
    label932:
    int j;
    if ((((BitmapFactory.Options)localObject).outHeight < paramInt) && (((BitmapFactory.Options)localObject).outWidth < paramInt))
    {
      paramContext = BitmapUtil.createThumbBitmap(paramContext, ((BitmapFactory.Options)localObject).outHeight, ((BitmapFactory.Options)localObject).outWidth, true, false);
      j = this.field_catalog;
      if (paramContext != null) {
        break label1004;
      }
      paramInt = 0;
      label944:
      if (paramContext != null) {
        break label1012;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiInfo", "id:%s width:%s height:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(i) });
      AppMethodBeat.o(105030);
      break;
      paramContext = BitmapUtil.createThumbBitmap(paramContext, paramInt, paramInt, true, false);
      break label932;
      label1004:
      paramInt = paramContext.getWidth();
      break label944;
      label1012:
      i = paramContext.getHeight();
    }
  }
  
  public final boolean Qv()
  {
    return (this.field_catalog == YCC) || (this.field_catalog == YCB);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(105036);
    this.field_captureStatus = parama.ordinal();
    AppMethodBeat.o(105036);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(105037);
    this.field_captureUploadErrCode = paramb.ordinal();
    AppMethodBeat.o(105037);
  }
  
  public final String aCt()
  {
    return this.field_groupId;
  }
  
  public final void aGn(int paramInt)
  {
    this.field_catalog = paramInt;
  }
  
  public final void aGo(int paramInt)
  {
    this.field_reserved3 = paramInt;
  }
  
  /* Error */
  public final void bA(java.util.ArrayList<String> paramArrayList)
  {
    // Byte code:
    //   0: ldc_w 832
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 834	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 835	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_2
    //   14: new 837	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 840	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore 6
    //   24: aload 6
    //   26: astore 4
    //   28: aload_2
    //   29: astore_3
    //   30: aload 6
    //   32: aload_1
    //   33: invokevirtual 844	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   36: aload 6
    //   38: astore 4
    //   40: aload_2
    //   41: astore_3
    //   42: aload_0
    //   43: aload_2
    //   44: invokevirtual 848	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   47: putfield 504	com/tencent/mm/storage/emotion/EmojiInfo:field_attachedEmojiMD5	[B
    //   50: aload 6
    //   52: invokevirtual 851	java/io/ObjectOutputStream:close	()V
    //   55: aload_2
    //   56: invokevirtual 852	java/io/ByteArrayOutputStream:close	()V
    //   59: ldc_w 832
    //   62: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   65: return
    //   66: astore_1
    //   67: ldc_w 555
    //   70: new 131	java/lang/StringBuilder
    //   73: dup
    //   74: ldc_w 854
    //   77: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: aload_1
    //   81: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: goto -38 -> 55
    //   96: astore_1
    //   97: ldc_w 555
    //   100: new 131	java/lang/StringBuilder
    //   103: dup
    //   104: ldc_w 856
    //   107: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload_1
    //   111: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   114: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: ldc_w 832
    //   126: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   129: return
    //   130: astore 5
    //   132: aconst_null
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_1
    //   137: astore 4
    //   139: aload_2
    //   140: astore_3
    //   141: ldc_w 555
    //   144: new 131	java/lang/StringBuilder
    //   147: dup
    //   148: ldc_w 858
    //   151: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload 5
    //   156: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   159: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 851	java/io/ObjectOutputStream:close	()V
    //   176: aload_2
    //   177: ifnull +7 -> 184
    //   180: aload_2
    //   181: invokevirtual 852	java/io/ByteArrayOutputStream:close	()V
    //   184: ldc_w 832
    //   187: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: return
    //   191: astore_1
    //   192: ldc_w 555
    //   195: new 131	java/lang/StringBuilder
    //   198: dup
    //   199: ldc_w 854
    //   202: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   205: aload_1
    //   206: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: goto -42 -> 176
    //   221: astore_1
    //   222: ldc_w 555
    //   225: new 131	java/lang/StringBuilder
    //   228: dup
    //   229: ldc_w 856
    //   232: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   235: aload_1
    //   236: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   239: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: ldc_w 832
    //   251: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: return
    //   255: astore_1
    //   256: aconst_null
    //   257: astore 4
    //   259: aconst_null
    //   260: astore_2
    //   261: aload 4
    //   263: ifnull +8 -> 271
    //   266: aload 4
    //   268: invokevirtual 851	java/io/ObjectOutputStream:close	()V
    //   271: aload_2
    //   272: ifnull +7 -> 279
    //   275: aload_2
    //   276: invokevirtual 852	java/io/ByteArrayOutputStream:close	()V
    //   279: ldc_w 832
    //   282: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   285: aload_1
    //   286: athrow
    //   287: astore_3
    //   288: ldc_w 555
    //   291: new 131	java/lang/StringBuilder
    //   294: dup
    //   295: ldc_w 854
    //   298: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   301: aload_3
    //   302: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: goto -43 -> 271
    //   317: astore_2
    //   318: ldc_w 555
    //   321: new 131	java/lang/StringBuilder
    //   324: dup
    //   325: ldc_w 856
    //   328: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   331: aload_2
    //   332: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: goto -65 -> 279
    //   347: astore_1
    //   348: aconst_null
    //   349: astore 4
    //   351: goto -90 -> 261
    //   354: astore_1
    //   355: aload_3
    //   356: astore_2
    //   357: goto -96 -> 261
    //   360: astore 5
    //   362: aconst_null
    //   363: astore_1
    //   364: goto -228 -> 136
    //   367: astore 5
    //   369: aload 6
    //   371: astore_1
    //   372: goto -236 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	EmojiInfo
    //   0	375	1	paramArrayList	java.util.ArrayList<String>
    //   13	263	2	localByteArrayOutputStream1	java.io.ByteArrayOutputStream
    //   317	15	2	localException1	Exception
    //   356	1	2	localObject1	Object
    //   29	112	3	localByteArrayOutputStream2	java.io.ByteArrayOutputStream
    //   287	69	3	localException2	Exception
    //   26	324	4	localObject2	Object
    //   130	25	5	localException3	Exception
    //   360	1	5	localException4	Exception
    //   367	1	5	localException5	Exception
    //   22	348	6	localObjectOutputStream	java.io.ObjectOutputStream
    // Exception table:
    //   from	to	target	type
    //   50	55	66	java/lang/Exception
    //   55	59	96	java/lang/Exception
    //   6	14	130	java/lang/Exception
    //   172	176	191	java/lang/Exception
    //   180	184	221	java/lang/Exception
    //   6	14	255	finally
    //   266	271	287	java/lang/Exception
    //   275	279	317	java/lang/Exception
    //   14	24	347	finally
    //   30	36	354	finally
    //   42	50	354	finally
    //   141	168	354	finally
    //   14	24	360	java/lang/Exception
    //   30	36	367	java/lang/Exception
    //   42	50	367	java/lang/Exception
  }
  
  public final void bIR(String paramString)
  {
    this.field_groupId = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105044);
    if ((paramObject != null) && ((paramObject instanceof EmojiInfo)) && (((EmojiInfo)paramObject).getMd5().equalsIgnoreCase(this.field_md5)))
    {
      AppMethodBeat.o(105044);
      return true;
    }
    AppMethodBeat.o(105044);
    return false;
  }
  
  public final boolean gRk()
  {
    AppMethodBeat.i(105035);
    if (getMd5().length() == 32)
    {
      AppMethodBeat.o(105035);
      return true;
    }
    AppMethodBeat.o(105035);
    return false;
  }
  
  public final String getContent()
  {
    if (this.field_content == null) {
      return "";
    }
    return this.field_content;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final int getIndex()
  {
    return this.field_idx;
  }
  
  public final String getMd5()
  {
    if (this.field_md5 == null) {
      return "";
    }
    return this.field_md5;
  }
  
  public final String getName()
  {
    if (this.field_name == null) {
      return "";
    }
    return this.field_name;
  }
  
  public final int getSize()
  {
    return this.field_size;
  }
  
  public final int getType()
  {
    return this.field_type;
  }
  
  public final void hBA()
  {
    this.field_temp = 1;
  }
  
  public final a hBB()
  {
    switch (this.field_captureStatus)
    {
    default: 
      return a.VIi;
    case 0: 
      return a.VIi;
    case 1: 
      return a.VIj;
    case 2: 
      return a.VIk;
    case 3: 
      return a.VIl;
    }
    return a.VIm;
  }
  
  public final int hBC()
  {
    return this.field_captureUploadCounter;
  }
  
  public final void hBD()
  {
    this.field_captureUploadCounter += 1;
  }
  
  public final b hBE()
  {
    switch (this.field_captureUploadErrCode)
    {
    default: 
      return b.VIu;
    case 0: 
      return b.VIo;
    case 1: 
      return b.VIp;
    case 2: 
      return b.VIq;
    case 3: 
      return b.VIr;
    case 4: 
      return b.VIs;
    case 5: 
      return b.VIt;
    case 6: 
      return b.VIu;
    case 7: 
      return b.VIv;
    case 8: 
      return b.VIw;
    case 9: 
      return b.VIx;
    }
    return b.VIy;
  }
  
  public final boolean hBo()
  {
    AppMethodBeat.i(225029);
    if (com.tencent.mm.plugin.emoji.i.b.avc(this.field_md5))
    {
      AppMethodBeat.o(225029);
      return true;
    }
    String str = ifi();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(225029);
      return false;
    }
    boolean bool = u.agG(str);
    AppMethodBeat.o(225029);
    return bool;
  }
  
  public final boolean hBp()
  {
    AppMethodBeat.i(105026);
    if (com.tencent.mm.plugin.emoji.i.b.avc(this.field_md5))
    {
      AppMethodBeat.o(105026);
      return true;
    }
    if ((this.field_catalog == EmojiGroupInfo.YCv) || (this.field_catalog == YCC) || (this.field_catalog == YCB))
    {
      AppMethodBeat.o(105026);
      return true;
    }
    Object localObject = ifh();
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(105026);
      return false;
    }
    localObject = new q((String)localObject);
    if ((((q)localObject).ifE()) && (((q)localObject).length() > 0L))
    {
      AppMethodBeat.o(105026);
      return true;
    }
    AppMethodBeat.o(105026);
    return false;
  }
  
  public final void hBq()
  {
    AppMethodBeat.i(105027);
    if ((this.field_catalog == YCC) || (this.field_catalog == YCB))
    {
      AppMethodBeat.o(105027);
      return;
    }
    Object localObject = ifh();
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = new q((String)localObject);
      if (((q)localObject).ifE()) {
        ((q)localObject).cFq();
      }
    }
    AppMethodBeat.o(105027);
  }
  
  public final boolean hBr()
  {
    AppMethodBeat.i(225039);
    if ((this.field_catalog == YCC) || (this.field_catalog == YCB))
    {
      AppMethodBeat.o(225039);
      return true;
    }
    String str = ifh();
    if (Util.isNullOrNil(str))
    {
      AppMethodBeat.o(225039);
      return false;
    }
    boolean bool = new q(str).ifE();
    AppMethodBeat.o(225039);
    return bool;
  }
  
  public final Bitmap hBs()
  {
    try
    {
      AppMethodBeat.i(177040);
      Bitmap localBitmap = hBt();
      AppMethodBeat.o(177040);
      return localBitmap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final Bitmap hBt()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 971
    //   5: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokevirtual 697	com/tencent/mm/storage/emotion/EmojiInfo:ifi	()Ljava/lang/String;
    //   12: invokestatic 702	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   15: ifeq +26 -> 41
    //   18: aload_0
    //   19: invokevirtual 697	com/tencent/mm/storage/emotion/EmojiInfo:ifi	()Ljava/lang/String;
    //   22: aconst_null
    //   23: invokestatic 972	com/tencent/mm/sdk/platformtools/BitmapUtil:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull +13 -> 41
    //   31: ldc_w 971
    //   34: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: areturn
    //   41: getstatic 978	com/tencent/mm/emoji/decode/MMGIFJNIFactory:Companion	Lcom/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion;
    //   44: aload_0
    //   45: invokevirtual 984	com/tencent/mm/emoji/decode/MMGIFJNIFactory$Companion:decodeThumb	(Lcom/tencent/mm/storage/emotion/EmojiInfo;)Landroid/graphics/Bitmap;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +18 -> 68
    //   53: aload_1
    //   54: bipush 100
    //   56: getstatic 990	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   59: aload_0
    //   60: invokevirtual 697	com/tencent/mm/storage/emotion/EmojiInfo:ifi	()Ljava/lang/String;
    //   63: iconst_0
    //   64: invokestatic 994	com/tencent/mm/sdk/platformtools/BitmapUtil:saveBitmapToImage	(Landroid/graphics/Bitmap;ILandroid/graphics/Bitmap$CompressFormat;Ljava/lang/String;Z)Z
    //   67: pop
    //   68: ldc_w 971
    //   71: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: goto -37 -> 37
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    //   82: astore_2
    //   83: ldc_w 555
    //   86: aload_2
    //   87: ldc_w 996
    //   90: iconst_0
    //   91: anewarray 559	java/lang/Object
    //   94: invokestatic 679	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: goto -29 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	EmojiInfo
    //   26	28	1	localBitmap	Bitmap
    //   77	4	1	localObject	Object
    //   82	5	2	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	27	77	finally
    //   31	37	77	finally
    //   41	49	77	finally
    //   53	68	77	finally
    //   68	74	77	finally
    //   83	97	77	finally
    //   53	68	82	java/io/IOException
  }
  
  public final boolean hBu()
  {
    return (this.field_catalog == YCC) || (this.field_catalog == YCB) || (this.field_catalog == EmojiGroupInfo.YCv);
  }
  
  public final boolean hBv()
  {
    AppMethodBeat.i(105032);
    boolean bool = this.field_groupId.equalsIgnoreCase("com.tencent.xin.emoticon.tuzki2");
    AppMethodBeat.o(105032);
    return bool;
  }
  
  public final boolean hBw()
  {
    AppMethodBeat.i(105034);
    if (!Util.isNullOrNil(this.field_wxamMd5))
    {
      AppMethodBeat.o(105034);
      return true;
    }
    AppMethodBeat.o(105034);
    return false;
  }
  
  public final String hBx()
  {
    if (this.field_svrid == null) {
      return "";
    }
    return this.field_svrid;
  }
  
  public final int hBy()
  {
    return this.field_catalog;
  }
  
  public final int hBz()
  {
    return this.field_reserved3;
  }
  
  /* Error */
  public final java.util.ArrayList<String> ifg()
  {
    // Byte code:
    //   0: ldc_w 1009
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 1011	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_0
    //   11: getfield 504	com/tencent/mm/storage/emotion/EmojiInfo:field_attachedEmojiMD5	[B
    //   14: invokespecial 1013	java/io/ByteArrayInputStream:<init>	([B)V
    //   17: astore_2
    //   18: new 1015	java/io/ObjectInputStream
    //   21: dup
    //   22: aload_2
    //   23: invokespecial 1018	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   26: astore_1
    //   27: aload_1
    //   28: astore 4
    //   30: aload_2
    //   31: astore_3
    //   32: aload_1
    //   33: invokevirtual 1022	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   36: checkcast 1024	java/util/ArrayList
    //   39: astore 5
    //   41: aload_2
    //   42: invokevirtual 1025	java/io/ByteArrayInputStream:close	()V
    //   45: aload_1
    //   46: invokevirtual 1026	java/io/ObjectInputStream:close	()V
    //   49: aload 5
    //   51: astore_1
    //   52: ldc_w 1009
    //   55: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: aload_1
    //   59: areturn
    //   60: astore_2
    //   61: ldc_w 555
    //   64: new 131	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 1028
    //   71: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload_2
    //   75: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   78: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: goto -42 -> 45
    //   90: astore_1
    //   91: ldc_w 555
    //   94: new 131	java/lang/StringBuilder
    //   97: dup
    //   98: ldc_w 1030
    //   101: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   104: aload_1
    //   105: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   108: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 5
    //   119: astore_1
    //   120: goto -68 -> 52
    //   123: astore 5
    //   125: aconst_null
    //   126: astore_1
    //   127: aconst_null
    //   128: astore_2
    //   129: aload_1
    //   130: astore 4
    //   132: aload_2
    //   133: astore_3
    //   134: ldc_w 555
    //   137: new 131	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 1032
    //   144: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload 5
    //   149: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   152: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_2
    //   162: ifnull +7 -> 169
    //   165: aload_2
    //   166: invokevirtual 1025	java/io/ByteArrayInputStream:close	()V
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 1026	java/io/ObjectInputStream:close	()V
    //   177: aconst_null
    //   178: astore_1
    //   179: goto -127 -> 52
    //   182: astore_2
    //   183: ldc_w 555
    //   186: new 131	java/lang/StringBuilder
    //   189: dup
    //   190: ldc_w 1028
    //   193: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   196: aload_2
    //   197: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   200: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: goto -40 -> 169
    //   212: astore_1
    //   213: ldc_w 555
    //   216: new 131	java/lang/StringBuilder
    //   219: dup
    //   220: ldc_w 1030
    //   223: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   226: aload_1
    //   227: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aconst_null
    //   240: astore_1
    //   241: goto -189 -> 52
    //   244: astore_1
    //   245: aconst_null
    //   246: astore 4
    //   248: aconst_null
    //   249: astore_2
    //   250: aload_2
    //   251: ifnull +7 -> 258
    //   254: aload_2
    //   255: invokevirtual 1025	java/io/ByteArrayInputStream:close	()V
    //   258: aload 4
    //   260: ifnull +8 -> 268
    //   263: aload 4
    //   265: invokevirtual 1026	java/io/ObjectInputStream:close	()V
    //   268: ldc_w 1009
    //   271: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   274: aload_1
    //   275: athrow
    //   276: astore_2
    //   277: ldc_w 555
    //   280: new 131	java/lang/StringBuilder
    //   283: dup
    //   284: ldc_w 1028
    //   287: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   290: aload_2
    //   291: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   294: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   303: goto -45 -> 258
    //   306: astore_2
    //   307: ldc_w 555
    //   310: new 131	java/lang/StringBuilder
    //   313: dup
    //   314: ldc_w 1030
    //   317: invokespecial 631	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   320: aload_2
    //   321: invokevirtual 591	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   324: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 355	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 734	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: goto -65 -> 268
    //   336: astore_1
    //   337: aconst_null
    //   338: astore 4
    //   340: goto -90 -> 250
    //   343: astore_1
    //   344: aload_3
    //   345: astore_2
    //   346: goto -96 -> 250
    //   349: astore 5
    //   351: aconst_null
    //   352: astore_1
    //   353: goto -224 -> 129
    //   356: astore 5
    //   358: goto -229 -> 129
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	EmojiInfo
    //   26	33	1	localObject1	Object
    //   90	15	1	localException1	Exception
    //   119	60	1	localObject2	Object
    //   212	15	1	localException2	Exception
    //   240	1	1	localObject3	Object
    //   244	31	1	localObject4	Object
    //   336	1	1	localObject5	Object
    //   343	1	1	localObject6	Object
    //   352	1	1	localObject7	Object
    //   17	25	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   60	15	2	localException3	Exception
    //   128	38	2	localObject8	Object
    //   182	15	2	localException4	Exception
    //   249	6	2	localObject9	Object
    //   276	15	2	localException5	Exception
    //   306	15	2	localException6	Exception
    //   345	1	2	localObject10	Object
    //   31	314	3	localObject11	Object
    //   28	311	4	localObject12	Object
    //   39	79	5	localArrayList	java.util.ArrayList
    //   123	25	5	localException7	Exception
    //   349	1	5	localException8	Exception
    //   356	1	5	localException9	Exception
    // Exception table:
    //   from	to	target	type
    //   41	45	60	java/lang/Exception
    //   45	49	90	java/lang/Exception
    //   6	18	123	java/lang/Exception
    //   165	169	182	java/lang/Exception
    //   173	177	212	java/lang/Exception
    //   6	18	244	finally
    //   254	258	276	java/lang/Exception
    //   263	268	306	java/lang/Exception
    //   18	27	336	finally
    //   32	41	343	finally
    //   134	161	343	finally
    //   18	27	349	java/lang/Exception
    //   32	41	356	java/lang/Exception
  }
  
  public final String ifh()
  {
    AppMethodBeat.i(105040);
    if ((Util.isNullOrNil(this.field_groupId)) && (Util.isNullOrNil(this.field_md5)))
    {
      Log.w("MicroMsg.emoji.EmojiInfo", "[cpan] get icon path failed. product id and md5 are null.");
      AppMethodBeat.o(105040);
      return null;
    }
    if (!Util.isNullOrNil(this.field_md5))
    {
      if ((Util.isNullOrNil(this.field_groupId)) || (Util.isEqual(this.field_groupId, "capture"))) {}
      for (String str = this.HlQ;; str = this.HlQ + this.field_groupId + "/")
      {
        u.bBD(str);
        str = str + this.field_md5;
        AppMethodBeat.o(105040);
        return str;
      }
    }
    AppMethodBeat.o(105040);
    return null;
  }
  
  public final String ifi()
  {
    AppMethodBeat.i(105041);
    String str = ifh();
    if (str == null) {}
    for (str = null; !com.tencent.mm.plugin.emoji.i.b.y(this); str = str + "_cover")
    {
      AppMethodBeat.o(105041);
      return str;
    }
    str = com.tencent.mm.loader.j.b.aSD() + "emoji/cover/" + getMd5() + "_cover";
    AppMethodBeat.o(105041);
    return str;
  }
  
  public final boolean isGif()
  {
    return (this.field_type == YCF) || (this.field_type == ZuB);
  }
  
  /* Error */
  public final byte[] oH(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc_w 1065
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: iflt +7 -> 14
    //   10: iload_2
    //   11: ifge +11 -> 22
    //   14: ldc_w 1065
    //   17: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: aload_0
    //   23: getfield 405	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   26: getstatic 68	com/tencent/mm/storage/emotion/EmojiInfo:YCz	I
    //   29: if_icmpeq +23 -> 52
    //   32: aload_0
    //   33: getfield 405	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   36: getstatic 74	com/tencent/mm/storage/emotion/EmojiInfo:YCC	I
    //   39: if_icmpeq +13 -> 52
    //   42: aload_0
    //   43: getfield 405	com/tencent/mm/storage/emotion/EmojiInfo:field_catalog	I
    //   46: getstatic 72	com/tencent/mm/storage/emotion/EmojiInfo:YCB	I
    //   49: if_icmpne +157 -> 206
    //   52: ldc_w 555
    //   55: ldc_w 1067
    //   58: iconst_1
    //   59: anewarray 559	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload_0
    //   65: invokevirtual 609	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   68: aastore
    //   69: invokestatic 565	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: invokestatic 1071	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   75: aload_0
    //   76: invokevirtual 609	com/tencent/mm/storage/emotion/EmojiInfo:getName	()Ljava/lang/String;
    //   79: invokestatic 1073	com/tencent/mm/storage/emotion/EmojiInfo:cH	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/InputStream;
    //   82: astore 6
    //   84: iload_1
    //   85: i2l
    //   86: lstore_3
    //   87: aload 6
    //   89: astore 5
    //   91: aload 6
    //   93: lload_3
    //   94: invokevirtual 1079	java/io/InputStream:skip	(J)J
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
    //   117: invokevirtual 1083	java/io/InputStream:read	([BII)I
    //   120: pop
    //   121: aload 6
    //   123: ifnull +8 -> 131
    //   126: aload 6
    //   128: invokevirtual 1084	java/io/InputStream:close	()V
    //   131: ldc_w 1065
    //   134: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   137: aload 7
    //   139: areturn
    //   140: astore 5
    //   142: ldc_w 555
    //   145: ldc_w 1086
    //   148: iconst_1
    //   149: anewarray 559	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 5
    //   156: invokestatic 1090	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   159: aastore
    //   160: invokestatic 1092	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   163: goto -32 -> 131
    //   166: astore 7
    //   168: aconst_null
    //   169: astore 6
    //   171: aload 6
    //   173: astore 5
    //   175: ldc_w 555
    //   178: ldc_w 1086
    //   181: iconst_1
    //   182: anewarray 559	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload 7
    //   189: invokestatic 1090	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   192: aastore
    //   193: invokestatic 1092	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload 6
    //   198: ifnull +8 -> 206
    //   201: aload 6
    //   203: invokevirtual 1084	java/io/InputStream:close	()V
    //   206: aload_0
    //   207: invokevirtual 712	com/tencent/mm/storage/emotion/EmojiInfo:ifh	()Ljava/lang/String;
    //   210: aload_0
    //   211: getfield 414	com/tencent/mm/storage/emotion/EmojiInfo:field_start	I
    //   214: iload_2
    //   215: invokestatic 1096	com/tencent/mm/vfs/u:aY	(Ljava/lang/String;II)[B
    //   218: astore 5
    //   220: ldc_w 1065
    //   223: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload 5
    //   228: areturn
    //   229: astore 5
    //   231: ldc_w 555
    //   234: ldc_w 1086
    //   237: iconst_1
    //   238: anewarray 559	java/lang/Object
    //   241: dup
    //   242: iconst_0
    //   243: aload 5
    //   245: invokestatic 1090	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   248: aastore
    //   249: invokestatic 1092	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   252: goto -46 -> 206
    //   255: astore 6
    //   257: aconst_null
    //   258: astore 5
    //   260: aload 5
    //   262: ifnull +8 -> 270
    //   265: aload 5
    //   267: invokevirtual 1084	java/io/InputStream:close	()V
    //   270: ldc_w 1065
    //   273: invokestatic 366	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload 6
    //   278: athrow
    //   279: astore 5
    //   281: ldc_w 555
    //   284: ldc_w 1086
    //   287: iconst_1
    //   288: anewarray 559	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: aload 5
    //   295: invokestatic 1090	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   298: aastore
    //   299: invokestatic 1092	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: goto -32 -> 270
    //   305: astore 6
    //   307: goto -47 -> 260
    //   310: astore 7
    //   312: goto -141 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	EmojiInfo
    //   0	315	1	paramInt1	int
    //   0	315	2	paramInt2	int
    //   86	8	3	l	long
    //   89	21	5	localInputStream1	InputStream
    //   140	15	5	localIOException1	java.io.IOException
    //   173	54	5	localObject1	Object
    //   229	15	5	localIOException2	java.io.IOException
    //   258	8	5	localObject2	Object
    //   279	15	5	localIOException3	java.io.IOException
    //   82	120	6	localInputStream2	InputStream
    //   255	22	6	localObject3	Object
    //   305	1	6	localObject4	Object
    //   105	33	7	arrayOfByte	byte[]
    //   166	22	7	localIOException4	java.io.IOException
    //   310	1	7	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   126	131	140	java/io/IOException
    //   52	84	166	java/io/IOException
    //   201	206	229	java/io/IOException
    //   52	84	255	finally
    //   265	270	279	java/io/IOException
    //   91	98	305	finally
    //   102	107	305	finally
    //   111	121	305	finally
    //   175	196	305	finally
    //   91	98	310	java/io/IOException
    //   102	107	310	java/io/IOException
    //   111	121	310	java/io/IOException
  }
  
  public final void reset()
  {
    AppMethodBeat.i(105024);
    this.field_md5 = "";
    this.field_svrid = "";
    this.field_catalog = YCx;
    this.field_type = YCE;
    this.field_size = 0;
    this.field_start = 0;
    this.field_state = ZuD;
    this.field_name = "";
    this.field_content = "";
    this.field_reserved1 = "";
    this.field_reserved2 = "";
    this.field_reserved3 = 0;
    this.field_reserved4 = 0;
    this.field_app_id = "";
    this.field_temp = 0;
    this.field_captureStatus = a.VIi.ordinal();
    this.field_captureUploadErrCode = b.VIo.ordinal();
    this.field_captureUploadCounter = 0;
    this.field_imitateMd5 = "";
    this.field_attachedEmojiMD5 = new byte[0];
    this.UaI = "";
    AppMethodBeat.o(105024);
  }
  
  public final void setMd5(String paramString)
  {
    this.field_md5 = paramString;
  }
  
  public final void setSize(int paramInt)
  {
    this.field_size = paramInt;
  }
  
  public final void setState(int paramInt)
  {
    this.field_state = paramInt;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
  }
  
  public String toString()
  {
    AppMethodBeat.i(105045);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("field_md5:").append(this.field_md5).append("\n");
    ((StringBuilder)localObject).append("field_svrid:").append(this.field_svrid).append("\n");
    ((StringBuilder)localObject).append("field_catalog:").append(this.field_catalog).append("\n");
    ((StringBuilder)localObject).append("field_type:").append(this.field_type).append("\n");
    ((StringBuilder)localObject).append("field_size:").append(this.field_size).append("\n");
    ((StringBuilder)localObject).append("field_start:").append(this.field_start).append("\n");
    ((StringBuilder)localObject).append("field_state:").append(this.field_state).append("\n");
    ((StringBuilder)localObject).append("field_name:").append(this.field_name).append("\n");
    ((StringBuilder)localObject).append("field_content:").append(this.field_content).append("\n");
    ((StringBuilder)localObject).append("field_reserved1:").append(this.field_reserved1).append("\n");
    ((StringBuilder)localObject).append("field_reserved2:").append(this.field_reserved2).append("\n");
    ((StringBuilder)localObject).append("field_reserved3:").append(this.field_reserved3).append("\n");
    ((StringBuilder)localObject).append("field_reserved4:").append(this.field_reserved4).append("\n");
    ((StringBuilder)localObject).append("field_app_id:").append(this.field_app_id).append("\n");
    ((StringBuilder)localObject).append("field_groupId:").append(this.field_groupId).append("\n");
    ((StringBuilder)localObject).append("field_lastUseTime:").append(this.field_lastUseTime).append("\n");
    ((StringBuilder)localObject).append("field_framesInfo:").append(this.field_framesInfo).append("\n");
    ((StringBuilder)localObject).append("field_idx:").append(this.field_idx).append("\n");
    ((StringBuilder)localObject).append("field_temp:").append(this.field_temp).append("\n");
    ((StringBuilder)localObject).append("field_source:").append(this.field_source).append("\n");
    ((StringBuilder)localObject).append("field_needupload:").append(this.field_needupload).append("\n");
    ((StringBuilder)localObject).append("field_designerID:").append(this.field_designerID).append("\n");
    ((StringBuilder)localObject).append("field_thumbUrl:").append(this.field_thumbUrl).append("\n");
    ((StringBuilder)localObject).append("field_captureStatus:").append(this.field_captureStatus).append("\n");
    ((StringBuilder)localObject).append("field_captureUploadErrCode").append(this.field_captureUploadErrCode).append("\n");
    ((StringBuilder)localObject).append("field_captureUploadCounter").append(this.field_captureUploadCounter).append("\n");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(105045);
    return localObject;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(105046);
    paramParcel.writeString(this.HlQ);
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
    paramParcel.writeLong(this.systemRowid);
    paramParcel.writeString(this.field_wxamMd5);
    paramParcel.writeString(this.field_attachedText);
    paramParcel.writeInt(this.field_captureStatus);
    if ((this.field_attachedEmojiMD5 != null) && (this.field_attachedEmojiMD5.length > 0))
    {
      paramParcel.writeInt(this.field_attachedEmojiMD5.length);
      paramParcel.writeByteArray(this.field_attachedEmojiMD5);
    }
    for (;;)
    {
      paramParcel.writeString(this.field_imitateMd5);
      paramParcel.writeInt(this.field_captureUploadErrCode);
      paramParcel.writeInt(this.field_captureUploadCounter);
      paramParcel.writeLong(this.field_captureEnterTime);
      paramParcel.writeString(this.field_lensId);
      paramParcel.writeString(this.field_attachTextColor);
      paramParcel.writeInt(this.field_captureScene);
      paramParcel.writeString(this.field_externMd5);
      AppMethodBeat.o(105046);
      return;
      paramParcel.writeInt(0);
    }
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(105018);
      VIi = new a("STATUS_SUCCESS", 0);
      VIj = new a("STATUS_MIXING", 1);
      VIk = new a("STATUS_MIX_FAIL", 2);
      VIl = new a("STATUS_UPLOADING", 3);
      VIm = new a("STATUS_UPLOAD_FAIL", 4);
      VIn = new a[] { VIi, VIj, VIk, VIl, VIm };
      AppMethodBeat.o(105018);
    }
    
    private a() {}
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(105021);
      VIo = new b("ERR_SUCCESS", 0);
      VIp = new b("ERR_NON_NETWORK", 1);
      VIq = new b("ERR_WIFI_NETWORK", 2);
      VIr = new b("ERR_MOBILE_NETWORK", 3);
      VIs = new b("ERR_NOT_COMPLETED", 4);
      VIt = new b("ERR_OVER_LIMIT", 5);
      VIu = new b("ERR_OTHERS", 6);
      VIv = new b("ERR_LOCAL_FILE", 7);
      VIw = new b("ERR_OVER_SIZE", 8);
      VIx = new b("ERR_SPAM", 9);
      VIy = new b("ERR_OVER_UPLOAD_TIME", 10);
      VIz = new b("ERR_MIX_VIDEO_ZERO_FRAME", 11);
      VIA = new b("ERR_MIX_OUTPUT_EMPTY", 12);
      VIB = new b("ERR_MIX_PROCESS_KILL", 13);
      VIC = new b[] { VIo, VIp, VIq, VIr, VIs, VIt, VIu, VIv, VIw, VIx, VIy, VIz, VIA, VIB };
      AppMethodBeat.o(105021);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.emotion.EmojiInfo
 * JD-Core Version:    0.7.0.1
 */