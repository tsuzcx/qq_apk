package com.tencent.tmediacodec.g;

import android.media.MediaCodec;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmediacodec.b.e;
import com.tencent.tmediacodec.b.f;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public final class d
{
  public static final String[] ZPL = { "csd-0", "csd-1", "csd-2" };
  private static boolean ZPM;
  private static boolean ZPN;
  
  public static String a(MediaCodec paramMediaCodec)
  {
    AppMethodBeat.i(224618);
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramMediaCodec = paramMediaCodec.getName();
      AppMethodBeat.o(224618);
      return paramMediaCodec;
    }
    AppMethodBeat.o(224618);
    return "unknow-low-api-18";
  }
  
  public static boolean a(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    AppMethodBeat.i(224624);
    if ((Build.VERSION.SDK_INT >= 19) && (paramCodecCapabilities.isFeatureSupported("adaptive-playback")))
    {
      AppMethodBeat.o(224624);
      return true;
    }
    AppMethodBeat.o(224624);
    return false;
  }
  
  private static int aCl(int paramInt)
  {
    return (paramInt + 16 - 1) / 16;
  }
  
  public static int b(f paramf, e parame)
  {
    AppMethodBeat.i(224632);
    int j;
    if (parame.aMR != -1)
    {
      i = 0;
      j = 0;
      while (i < parame.ZOk.size())
      {
        j += ((byte[])parame.ZOk.get(i)).length;
        i += 1;
      }
    }
    for (int i = parame.aMR + j;; i = d(parame.aMQ, parame.width, parame.height, paramf.bcB))
    {
      AppMethodBeat.o(224632);
      return i;
    }
  }
  
  public static boolean b(MediaCodecInfo.CodecCapabilities paramCodecCapabilities)
  {
    AppMethodBeat.i(224626);
    if ((Build.VERSION.SDK_INT >= 21) && (paramCodecCapabilities.isFeatureSupported("secure-playback")))
    {
      AppMethodBeat.o(224626);
      return true;
    }
    AppMethodBeat.o(224626);
    return false;
  }
  
  public static boolean bJ(String paramString)
  {
    AppMethodBeat.i(224616);
    boolean bool = paramString.contains("video");
    AppMethodBeat.o(224616);
    return bool;
  }
  
  public static int d(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 2;
    AppMethodBeat.i(224646);
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      AppMethodBeat.o(224646);
      return -1;
    }
    label88:
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        AppMethodBeat.o(224646);
        return -1;
        if (!paramString.equals("video/3gpp")) {
          break label88;
        }
        i = 0;
        continue;
        if (!paramString.equals("video/mp4v-es")) {
          break label88;
        }
        i = 1;
        continue;
        if (!paramString.equals("video/avc")) {
          break label88;
        }
        i = 2;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp8")) {
          break label88;
        }
        i = 3;
        continue;
        if (!paramString.equals("video/hevc")) {
          break label88;
        }
        i = 4;
        continue;
        if (!paramString.equals("video/x-vnd.on2.vp9")) {
          break label88;
        }
        i = 5;
      }
    }
    paramInt1 *= paramInt2;
    paramInt2 = j;
    for (;;)
    {
      paramInt1 = paramInt1 * 3 / (paramInt2 * 2);
      AppMethodBeat.o(224646);
      return paramInt1;
      if (("BRAVIA 4K 2015".equals(Build.MODEL)) || (("Amazon".equals(Build.MANUFACTURER)) && (("KFSOWI".equals(Build.MODEL)) || (("AFTS".equals(Build.MODEL)) && (paramBoolean)))))
      {
        AppMethodBeat.o(224646);
        return -1;
      }
      paramInt1 = aCl(paramInt1) * aCl(paramInt2) * 16 * 16;
      paramInt2 = j;
      continue;
      paramInt1 *= paramInt2;
      paramInt2 = j;
      continue;
      paramInt1 *= paramInt2;
      paramInt2 = 4;
    }
  }
  
  public static ArrayList<byte[]> h(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(224653);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < ZPL.length)
    {
      ByteBuffer localByteBuffer = paramMediaFormat.getByteBuffer(ZPL[i]);
      if (localByteBuffer != null) {
        localArrayList.add(localByteBuffer.array());
      }
      i += 1;
    }
    AppMethodBeat.o(224653);
    return localArrayList;
  }
  
  public static boolean ito()
  {
    int j = 0;
    int i = 27;
    AppMethodBeat.i(224702);
    for (;;)
    {
      try
      {
        if (!ZPM)
        {
          if (("dangal".equals(Build.DEVICE)) || ((Build.VERSION.SDK_INT <= 27) && ("HWEML".equals(Build.DEVICE)))) {
            break label3221;
          }
          if (Build.VERSION.SDK_INT < 27) {
            str = Build.DEVICE;
          }
        }
        switch (str.hashCode())
        {
        case 1513190: 
          str = Build.MODEL;
          switch (str.hashCode())
          {
          case 2006354: 
            if (b.isLogEnable())
            {
              new StringBuilder("deviceNeedsSetOutputSurfaceWorkaround:").append(ZPN);
              b.bDP("TUtils");
            }
            ZPM = true;
            boolean bool = ZPN;
            AppMethodBeat.o(224702);
            return bool;
          }
          break;
        }
      }
      finally
      {
        String str;
        AppMethodBeat.o(224702);
      }
      if (str.equals("1601"))
      {
        i = 0;
        break label3230;
        if (str.equals("1713"))
        {
          i = 1;
          break label3230;
          if (str.equals("1714"))
          {
            i = 2;
            break label3230;
            if (str.equals("A10-70F"))
            {
              i = 3;
              break label3230;
              if (str.equals("A10-70L"))
              {
                i = 4;
                break label3230;
                if (str.equals("A1601"))
                {
                  i = 5;
                  break label3230;
                  if (str.equals("A2016a40"))
                  {
                    i = 6;
                    break label3230;
                    if (str.equals("A7000-a"))
                    {
                      i = 7;
                      break label3230;
                      if (str.equals("A7000plus"))
                      {
                        i = 8;
                        break label3230;
                        if (str.equals("A7010a48"))
                        {
                          i = 9;
                          break label3230;
                          if (str.equals("A7020a48"))
                          {
                            i = 10;
                            break label3230;
                            if (str.equals("AquaPowerM"))
                            {
                              i = 11;
                              break label3230;
                              if (str.equals("ASUS_X00AD_2"))
                              {
                                i = 12;
                                break label3230;
                                if (str.equals("Aura_Note_2"))
                                {
                                  i = 13;
                                  break label3230;
                                  if (str.equals("BLACK-1X"))
                                  {
                                    i = 14;
                                    break label3230;
                                    if (str.equals("BRAVIA_ATV2"))
                                    {
                                      i = 15;
                                      break label3230;
                                      if (str.equals("BRAVIA_ATV3_4K"))
                                      {
                                        i = 16;
                                        break label3230;
                                        if (str.equals("C1"))
                                        {
                                          i = 17;
                                          break label3230;
                                          if (str.equals("ComioS1"))
                                          {
                                            i = 18;
                                            break label3230;
                                            if (str.equals("CP8676_I02"))
                                            {
                                              i = 19;
                                              break label3230;
                                              if (str.equals("CPH1609"))
                                              {
                                                i = 20;
                                                break label3230;
                                                if (str.equals("CPY83_I00"))
                                                {
                                                  i = 21;
                                                  break label3230;
                                                  if (str.equals("cv1"))
                                                  {
                                                    i = 22;
                                                    break label3230;
                                                    if (str.equals("cv3"))
                                                    {
                                                      i = 23;
                                                      break label3230;
                                                      if (str.equals("deb"))
                                                      {
                                                        i = 24;
                                                        break label3230;
                                                        if (str.equals("E5643"))
                                                        {
                                                          i = 25;
                                                          break label3230;
                                                          if (str.equals("ELUGA_A3_Pro"))
                                                          {
                                                            i = 26;
                                                            break label3230;
                                                            if (str.equals("ELUGA_Note"))
                                                            {
                                                              break label3230;
                                                              if (str.equals("ELUGA_Prim"))
                                                              {
                                                                i = 28;
                                                                break label3230;
                                                                if (str.equals("ELUGA_Ray_X"))
                                                                {
                                                                  i = 29;
                                                                  break label3230;
                                                                  if (str.equals("EverStar_S"))
                                                                  {
                                                                    i = 30;
                                                                    break label3230;
                                                                    if (str.equals("F3111"))
                                                                    {
                                                                      i = 31;
                                                                      break label3230;
                                                                      if (str.equals("F3113"))
                                                                      {
                                                                        i = 32;
                                                                        break label3230;
                                                                        if (str.equals("F3116"))
                                                                        {
                                                                          i = 33;
                                                                          break label3230;
                                                                          if (str.equals("F3211"))
                                                                          {
                                                                            i = 34;
                                                                            break label3230;
                                                                            if (str.equals("F3213"))
                                                                            {
                                                                              i = 35;
                                                                              break label3230;
                                                                              if (str.equals("F3215"))
                                                                              {
                                                                                i = 36;
                                                                                break label3230;
                                                                                if (str.equals("F3311"))
                                                                                {
                                                                                  i = 37;
                                                                                  break label3230;
                                                                                  if (str.equals("flo"))
                                                                                  {
                                                                                    i = 38;
                                                                                    break label3230;
                                                                                    if (str.equals("fugu"))
                                                                                    {
                                                                                      i = 39;
                                                                                      break label3230;
                                                                                      if (str.equals("GiONEE_CBL7513"))
                                                                                      {
                                                                                        i = 40;
                                                                                        break label3230;
                                                                                        if (str.equals("GiONEE_GBL7319"))
                                                                                        {
                                                                                          i = 41;
                                                                                          break label3230;
                                                                                          if (str.equals("GIONEE_GBL7360"))
                                                                                          {
                                                                                            i = 42;
                                                                                            break label3230;
                                                                                            if (str.equals("GIONEE_SWW1609"))
                                                                                            {
                                                                                              i = 43;
                                                                                              break label3230;
                                                                                              if (str.equals("GIONEE_SWW1627"))
                                                                                              {
                                                                                                i = 44;
                                                                                                break label3230;
                                                                                                if (str.equals("GIONEE_SWW1631"))
                                                                                                {
                                                                                                  i = 45;
                                                                                                  break label3230;
                                                                                                  if (str.equals("GIONEE_WBL5708"))
                                                                                                  {
                                                                                                    i = 46;
                                                                                                    break label3230;
                                                                                                    if (str.equals("GIONEE_WBL7365"))
                                                                                                    {
                                                                                                      i = 47;
                                                                                                      break label3230;
                                                                                                      if (str.equals("GIONEE_WBL7519"))
                                                                                                      {
                                                                                                        i = 48;
                                                                                                        break label3230;
                                                                                                        if (str.equals("griffin"))
                                                                                                        {
                                                                                                          i = 49;
                                                                                                          break label3230;
                                                                                                          if (str.equals("htc_e56ml_dtul"))
                                                                                                          {
                                                                                                            i = 50;
                                                                                                            break label3230;
                                                                                                            if (str.equals("hwALE-H"))
                                                                                                            {
                                                                                                              i = 51;
                                                                                                              break label3230;
                                                                                                              if (str.equals("HWBLN-H"))
                                                                                                              {
                                                                                                                i = 52;
                                                                                                                break label3230;
                                                                                                                if (str.equals("HWCAM-H"))
                                                                                                                {
                                                                                                                  i = 53;
                                                                                                                  break label3230;
                                                                                                                  if (str.equals("HWVNS-H"))
                                                                                                                  {
                                                                                                                    i = 54;
                                                                                                                    break label3230;
                                                                                                                    if (str.equals("HWWAS-H"))
                                                                                                                    {
                                                                                                                      i = 55;
                                                                                                                      break label3230;
                                                                                                                      if (str.equals("i9031"))
                                                                                                                      {
                                                                                                                        i = 56;
                                                                                                                        break label3230;
                                                                                                                        if (str.equals("iball8735_9806"))
                                                                                                                        {
                                                                                                                          i = 57;
                                                                                                                          break label3230;
                                                                                                                          if (str.equals("Infinix-X572"))
                                                                                                                          {
                                                                                                                            i = 58;
                                                                                                                            break label3230;
                                                                                                                            if (str.equals("iris60"))
                                                                                                                            {
                                                                                                                              i = 59;
                                                                                                                              break label3230;
                                                                                                                              if (str.equals("itel_S41"))
                                                                                                                              {
                                                                                                                                i = 60;
                                                                                                                                break label3230;
                                                                                                                                if (str.equals("j2xlteins"))
                                                                                                                                {
                                                                                                                                  i = 61;
                                                                                                                                  break label3230;
                                                                                                                                  if (str.equals("JGZ"))
                                                                                                                                  {
                                                                                                                                    i = 62;
                                                                                                                                    break label3230;
                                                                                                                                    if (str.equals("K50a40"))
                                                                                                                                    {
                                                                                                                                      i = 63;
                                                                                                                                      break label3230;
                                                                                                                                      if (str.equals("kate"))
                                                                                                                                      {
                                                                                                                                        i = 64;
                                                                                                                                        break label3230;
                                                                                                                                        if (str.equals("l5460"))
                                                                                                                                        {
                                                                                                                                          i = 65;
                                                                                                                                          break label3230;
                                                                                                                                          if (str.equals("le_x6"))
                                                                                                                                          {
                                                                                                                                            i = 66;
                                                                                                                                            break label3230;
                                                                                                                                            if (str.equals("LS-5017"))
                                                                                                                                            {
                                                                                                                                              i = 67;
                                                                                                                                              break label3230;
                                                                                                                                              if (str.equals("M5c"))
                                                                                                                                              {
                                                                                                                                                i = 68;
                                                                                                                                                break label3230;
                                                                                                                                                if (str.equals("manning"))
                                                                                                                                                {
                                                                                                                                                  i = 69;
                                                                                                                                                  break label3230;
                                                                                                                                                  if (str.equals("marino_f"))
                                                                                                                                                  {
                                                                                                                                                    i = 70;
                                                                                                                                                    break label3230;
                                                                                                                                                    if (str.equals("MEIZU_M5"))
                                                                                                                                                    {
                                                                                                                                                      i = 71;
                                                                                                                                                      break label3230;
                                                                                                                                                      if (str.equals("mh"))
                                                                                                                                                      {
                                                                                                                                                        i = 72;
                                                                                                                                                        break label3230;
                                                                                                                                                        if (str.equals("mido"))
                                                                                                                                                        {
                                                                                                                                                          i = 73;
                                                                                                                                                          break label3230;
                                                                                                                                                          if (str.equals("c"))
                                                                                                                                                          {
                                                                                                                                                            i = 74;
                                                                                                                                                            break label3230;
                                                                                                                                                            if (str.equals("namath"))
                                                                                                                                                            {
                                                                                                                                                              i = 75;
                                                                                                                                                              break label3230;
                                                                                                                                                              if (str.equals("nicklaus_f"))
                                                                                                                                                              {
                                                                                                                                                                i = 76;
                                                                                                                                                                break label3230;
                                                                                                                                                                if (str.equals("NX541J"))
                                                                                                                                                                {
                                                                                                                                                                  i = 77;
                                                                                                                                                                  break label3230;
                                                                                                                                                                  if (str.equals("NX573J"))
                                                                                                                                                                  {
                                                                                                                                                                    i = 78;
                                                                                                                                                                    break label3230;
                                                                                                                                                                    if (str.equals("OnePlus5T"))
                                                                                                                                                                    {
                                                                                                                                                                      i = 79;
                                                                                                                                                                      break label3230;
                                                                                                                                                                      if (str.equals("p212"))
                                                                                                                                                                      {
                                                                                                                                                                        i = 80;
                                                                                                                                                                        break label3230;
                                                                                                                                                                        if (str.equals("P681"))
                                                                                                                                                                        {
                                                                                                                                                                          i = 81;
                                                                                                                                                                          break label3230;
                                                                                                                                                                          if (str.equals("P85"))
                                                                                                                                                                          {
                                                                                                                                                                            i = 82;
                                                                                                                                                                            break label3230;
                                                                                                                                                                            if (str.equals("panell_d"))
                                                                                                                                                                            {
                                                                                                                                                                              i = 83;
                                                                                                                                                                              break label3230;
                                                                                                                                                                              if (str.equals("panell_dl"))
                                                                                                                                                                              {
                                                                                                                                                                                i = 84;
                                                                                                                                                                                break label3230;
                                                                                                                                                                                if (str.equals("panell_ds"))
                                                                                                                                                                                {
                                                                                                                                                                                  i = 85;
                                                                                                                                                                                  break label3230;
                                                                                                                                                                                  if (str.equals("panell_dt"))
                                                                                                                                                                                  {
                                                                                                                                                                                    i = 86;
                                                                                                                                                                                    break label3230;
                                                                                                                                                                                    if (str.equals("PB2-670M"))
                                                                                                                                                                                    {
                                                                                                                                                                                      i = 87;
                                                                                                                                                                                      break label3230;
                                                                                                                                                                                      if (str.equals("PGN528"))
                                                                                                                                                                                      {
                                                                                                                                                                                        i = 88;
                                                                                                                                                                                        break label3230;
                                                                                                                                                                                        if (str.equals("PGN610"))
                                                                                                                                                                                        {
                                                                                                                                                                                          i = 89;
                                                                                                                                                                                          break label3230;
                                                                                                                                                                                          if (str.equals("PGN611"))
                                                                                                                                                                                          {
                                                                                                                                                                                            i = 90;
                                                                                                                                                                                            break label3230;
                                                                                                                                                                                            if (str.equals("Phantom6"))
                                                                                                                                                                                            {
                                                                                                                                                                                              i = 91;
                                                                                                                                                                                              break label3230;
                                                                                                                                                                                              if (str.equals("Pixi4-7_3G"))
                                                                                                                                                                                              {
                                                                                                                                                                                                i = 92;
                                                                                                                                                                                                break label3230;
                                                                                                                                                                                                if (str.equals("Pixi5-10_4G"))
                                                                                                                                                                                                {
                                                                                                                                                                                                  i = 93;
                                                                                                                                                                                                  break label3230;
                                                                                                                                                                                                  if (str.equals("PLE"))
                                                                                                                                                                                                  {
                                                                                                                                                                                                    i = 94;
                                                                                                                                                                                                    break label3230;
                                                                                                                                                                                                    if (str.equals("PRO7S"))
                                                                                                                                                                                                    {
                                                                                                                                                                                                      i = 95;
                                                                                                                                                                                                      break label3230;
                                                                                                                                                                                                      if (str.equals("Q350"))
                                                                                                                                                                                                      {
                                                                                                                                                                                                        i = 96;
                                                                                                                                                                                                        break label3230;
                                                                                                                                                                                                        if (str.equals("Q4260"))
                                                                                                                                                                                                        {
                                                                                                                                                                                                          i = 97;
                                                                                                                                                                                                          break label3230;
                                                                                                                                                                                                          if (str.equals("Q427"))
                                                                                                                                                                                                          {
                                                                                                                                                                                                            i = 98;
                                                                                                                                                                                                            break label3230;
                                                                                                                                                                                                            if (str.equals("Q4310"))
                                                                                                                                                                                                            {
                                                                                                                                                                                                              i = 99;
                                                                                                                                                                                                              break label3230;
                                                                                                                                                                                                              if (str.equals("Q5"))
                                                                                                                                                                                                              {
                                                                                                                                                                                                                i = 100;
                                                                                                                                                                                                                break label3230;
                                                                                                                                                                                                                if (str.equals("QM16XE_U"))
                                                                                                                                                                                                                {
                                                                                                                                                                                                                  i = 101;
                                                                                                                                                                                                                  break label3230;
                                                                                                                                                                                                                  if (str.equals("QX1"))
                                                                                                                                                                                                                  {
                                                                                                                                                                                                                    i = 102;
                                                                                                                                                                                                                    break label3230;
                                                                                                                                                                                                                    if (str.equals("santoni"))
                                                                                                                                                                                                                    {
                                                                                                                                                                                                                      i = 103;
                                                                                                                                                                                                                      break label3230;
                                                                                                                                                                                                                      if (str.equals("Slate_Pro"))
                                                                                                                                                                                                                      {
                                                                                                                                                                                                                        i = 104;
                                                                                                                                                                                                                        break label3230;
                                                                                                                                                                                                                        if (str.equals("SVP-DTV15"))
                                                                                                                                                                                                                        {
                                                                                                                                                                                                                          i = 105;
                                                                                                                                                                                                                          break label3230;
                                                                                                                                                                                                                          if (str.equals("s905x018"))
                                                                                                                                                                                                                          {
                                                                                                                                                                                                                            i = 106;
                                                                                                                                                                                                                            break label3230;
                                                                                                                                                                                                                            if (str.equals("taido_row"))
                                                                                                                                                                                                                            {
                                                                                                                                                                                                                              i = 107;
                                                                                                                                                                                                                              break label3230;
                                                                                                                                                                                                                              if (str.equals("TB3-730F"))
                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                i = 108;
                                                                                                                                                                                                                                break label3230;
                                                                                                                                                                                                                                if (str.equals("TB3-730X"))
                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                  i = 109;
                                                                                                                                                                                                                                  break label3230;
                                                                                                                                                                                                                                  if (str.equals("TB3-850F"))
                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                    i = 110;
                                                                                                                                                                                                                                    break label3230;
                                                                                                                                                                                                                                    if (str.equals("TB3-850M"))
                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                      i = 111;
                                                                                                                                                                                                                                      break label3230;
                                                                                                                                                                                                                                      if (str.equals("tcl_eu"))
                                                                                                                                                                                                                                      {
                                                                                                                                                                                                                                        i = 112;
                                                                                                                                                                                                                                        break label3230;
                                                                                                                                                                                                                                        if (str.equals("V1"))
                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                          i = 113;
                                                                                                                                                                                                                                          break label3230;
                                                                                                                                                                                                                                          if (str.equals("V23GB"))
                                                                                                                                                                                                                                          {
                                                                                                                                                                                                                                            i = 114;
                                                                                                                                                                                                                                            break label3230;
                                                                                                                                                                                                                                            if (str.equals("V5"))
                                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                              i = 115;
                                                                                                                                                                                                                                              break label3230;
                                                                                                                                                                                                                                              if (str.equals("vernee_M5"))
                                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                                i = 116;
                                                                                                                                                                                                                                                break label3230;
                                                                                                                                                                                                                                                if (str.equals("watson"))
                                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                                  i = 117;
                                                                                                                                                                                                                                                  break label3230;
                                                                                                                                                                                                                                                  if (str.equals("whyred"))
                                                                                                                                                                                                                                                  {
                                                                                                                                                                                                                                                    i = 118;
                                                                                                                                                                                                                                                    break label3230;
                                                                                                                                                                                                                                                    if (str.equals("woods_f"))
                                                                                                                                                                                                                                                    {
                                                                                                                                                                                                                                                      i = 119;
                                                                                                                                                                                                                                                      break label3230;
                                                                                                                                                                                                                                                      if (str.equals("woods_fn"))
                                                                                                                                                                                                                                                      {
                                                                                                                                                                                                                                                        i = 120;
                                                                                                                                                                                                                                                        break label3230;
                                                                                                                                                                                                                                                        if (str.equals("X3_HK"))
                                                                                                                                                                                                                                                        {
                                                                                                                                                                                                                                                          i = 121;
                                                                                                                                                                                                                                                          break label3230;
                                                                                                                                                                                                                                                          if (str.equals("XE2X"))
                                                                                                                                                                                                                                                          {
                                                                                                                                                                                                                                                            i = 122;
                                                                                                                                                                                                                                                            break label3230;
                                                                                                                                                                                                                                                            if (str.equals("XT1663"))
                                                                                                                                                                                                                                                            {
                                                                                                                                                                                                                                                              i = 123;
                                                                                                                                                                                                                                                              break label3230;
                                                                                                                                                                                                                                                              if (str.equals("Z12_PRO"))
                                                                                                                                                                                                                                                              {
                                                                                                                                                                                                                                                                i = 124;
                                                                                                                                                                                                                                                                break label3230;
                                                                                                                                                                                                                                                                if (str.equals("Z80"))
                                                                                                                                                                                                                                                                {
                                                                                                                                                                                                                                                                  i = 125;
                                                                                                                                                                                                                                                                  break label3230;
                                                                                                                                                                                                                                                                  ZPN = true;
                                                                                                                                                                                                                                                                  continue;
                                                                                                                                                                                                                                                                  if (!localObject.equals("AFTA")) {
                                                                                                                                                                                                                                                                    break label3751;
                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                                  i = j;
                                                                                                                                                                                                                                                                  break label3753;
                                                                                                                                                                                                                                                                  if (!localObject.equals("AFTN")) {
                                                                                                                                                                                                                                                                    break label3751;
                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                                  i = 1;
                                                                                                                                                                                                                                                                  break label3753;
                                                                                                                                                                                                                                                                  if (!localObject.equals("JSN-L21")) {
                                                                                                                                                                                                                                                                    break label3751;
                                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                                  i = 2;
                                                                                                                                                                                                                                                                  break label3753;
                                                                                                                                                                                                                                                                  label3221:
                                                                                                                                                                                                                                                                  ZPN = true;
                                                                                                                                                                                                                                                                  continue;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                              }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                          }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                      }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                  }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                              }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                          }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                      }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                  }
                                                                                                                                                                                                                }
                                                                                                                                                                                                              }
                                                                                                                                                                                                            }
                                                                                                                                                                                                          }
                                                                                                                                                                                                        }
                                                                                                                                                                                                      }
                                                                                                                                                                                                    }
                                                                                                                                                                                                  }
                                                                                                                                                                                                }
                                                                                                                                                                                              }
                                                                                                                                                                                            }
                                                                                                                                                                                          }
                                                                                                                                                                                        }
                                                                                                                                                                                      }
                                                                                                                                                                                    }
                                                                                                                                                                                  }
                                                                                                                                                                                }
                                                                                                                                                                              }
                                                                                                                                                                            }
                                                                                                                                                                          }
                                                                                                                                                                        }
                                                                                                                                                                      }
                                                                                                                                                                    }
                                                                                                                                                                  }
                                                                                                                                                                }
                                                                                                                                                              }
                                                                                                                                                            }
                                                                                                                                                          }
                                                                                                                                                        }
                                                                                                                                                      }
                                                                                                                                                    }
                                                                                                                                                  }
                                                                                                                                                }
                                                                                                                                              }
                                                                                                                                            }
                                                                                                                                          }
                                                                                                                                        }
                                                                                                                                      }
                                                                                                                                    }
                                                                                                                                  }
                                                                                                                                }
                                                                                                                              }
                                                                                                                            }
                                                                                                                          }
                                                                                                                        }
                                                                                                                      }
                                                                                                                    }
                                                                                                                  }
                                                                                                                }
                                                                                                              }
                                                                                                            }
                                                                                                          }
                                                                                                        }
                                                                                                      }
                                                                                                    }
                                                                                                  }
                                                                                                }
                                                                                              }
                                                                                            }
                                                                                          }
                                                                                        }
                                                                                      }
                                                                                    }
                                                                                  }
                                                                                }
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      i = -1;
      label3230:
      switch (i)
      {
      }
      continue;
      label3751:
      i = -1;
      label3753:
      switch (i)
      {
      }
    }
  }
  
  public static String s(Surface paramSurface)
  {
    AppMethodBeat.i(224623);
    try
    {
      Field localField = c.j(Surface.class, "mName");
      localField.setAccessible(true);
      paramSurface = String.valueOf(localField.get(paramSurface));
      AppMethodBeat.o(224623);
      return paramSurface;
    }
    catch (Throwable paramSurface)
    {
      b.bDU("TUtils");
      AppMethodBeat.o(224623);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tmediacodec.g.d
 * JD-Core Version:    0.7.0.1
 */