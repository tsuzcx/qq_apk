package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class g
{
  public int CpW = 0;
  
  private static byte[] M(InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(114847);
    Object localObject = new ByteArrayOutputStream();
    paramInputStream = new j(paramInputStream, (OutputStream)localObject);
    paramInputStream.UC(8);
    paramInputStream.UC(8);
    paramInputStream.UC(8);
    paramInputStream.UC(8);
    paramInputStream.UC(8);
    int i = (int)paramInputStream.ezq();
    paramInputStream.UC(8);
    paramInputStream.ezq();
    paramInputStream.ezu();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.ezt() == 3) {
        paramInputStream.UC(1);
      }
      paramInputStream.ezu();
      paramInputStream.ezu();
      paramInputStream.UC(1);
      if (paramInputStream.tn(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.tn(true))
          {
            if (i >= 6) {
              break label172;
            }
            paramInputStream.UD(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label172:
            paramInputStream.UD(64);
          }
        }
      }
    }
    paramInputStream.ezu();
    i = paramInputStream.ezt();
    if (i == 0)
    {
      paramInputStream.ezu();
      paramInputStream.ezu();
      paramInputStream.UC(1);
      paramInputStream.ezu();
      paramInputStream.ezu();
      if (!paramInputStream.tn(true)) {
        paramInputStream.UC(1);
      }
      paramInputStream.UC(1);
      if (paramInputStream.tn(true))
      {
        paramInputStream.ezu();
        paramInputStream.ezu();
        paramInputStream.ezu();
        paramInputStream.ezu();
      }
      if (!paramInputStream.tn(false)) {
        break label731;
      }
      ae.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
      paramInputStream.tp(true);
      if ((paramInputStream.tn(true)) && ((int)paramInputStream.ezq() == 255))
      {
        paramInputStream.UC(16);
        paramInputStream.UC(16);
      }
      if (paramInputStream.tn(true)) {
        paramInputStream.UC(1);
      }
      if (paramInputStream.tn(true))
      {
        paramInputStream.UC(3);
        paramInputStream.UC(1);
        if (paramInputStream.tn(true))
        {
          paramInputStream.UC(8);
          paramInputStream.UC(8);
          paramInputStream.UC(8);
        }
      }
      if (paramInputStream.tn(true))
      {
        paramInputStream.ezu();
        paramInputStream.ezu();
      }
      if (paramInputStream.tn(true))
      {
        paramInputStream.UC(32);
        paramInputStream.UC(32);
        paramInputStream.UC(1);
      }
      boolean bool1 = paramInputStream.tn(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.tn(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.UC(1);
      }
      paramInputStream.UC(1);
      if (!paramInputStream.tn(false)) {
        break label679;
      }
      ae.d("TAG", "steve:VUI has bs restriction!!");
      paramInputStream.tp(true);
      paramInputStream.tn(true);
      paramInputStream.ezu();
      paramInputStream.ezu();
      paramInputStream.ezu();
      paramInputStream.ezu();
      paramInputStream.ezu();
      paramInputStream.UG(1);
    }
    byte[] arrayOfByte;
    for (;;)
    {
      paramInputStream.UE(1);
      paramInputStream.af(0L, 8 - paramInputStream.CrD);
      paramInputStream.flush();
      arrayOfByte = ((ByteArrayOutputStream)localObject).toByteArray();
      paramInputStream = "";
      i = j;
      while (i < arrayOfByte.length)
      {
        String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
        localObject = str;
        if (str.length() == 1) {
          localObject = "0".concat(String.valueOf(str));
        }
        paramInputStream = paramInputStream + " " + (String)localObject;
        i += 1;
      }
      if (i != 1) {
        break;
      }
      paramInputStream.UC(1);
      paramInputStream.ezu();
      paramInputStream.ezu();
      int k = paramInputStream.ezt();
      i = 0;
      while (i < k)
      {
        new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
        paramInputStream.ezu();
        i += 1;
      }
      break;
      label679:
      ae.d("TAG", "steve:VUI has NO bs restriction!!");
      paramInputStream.tp(true);
      paramInputStream.tp(true);
      paramInputStream.UG(0);
      paramInputStream.UG(0);
      paramInputStream.UG(10);
      paramInputStream.UG(10);
      paramInputStream.UG(0);
      paramInputStream.UG(1);
      continue;
      label731:
      ae.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
      paramInputStream.tp(true);
      paramInputStream.tp(false);
      paramInputStream.tp(false);
      paramInputStream.tp(false);
      paramInputStream.tp(false);
      paramInputStream.tp(false);
      paramInputStream.tp(false);
      paramInputStream.tp(false);
      paramInputStream.tp(false);
      paramInputStream.tp(true);
      paramInputStream.tp(true);
      paramInputStream.UG(0);
      paramInputStream.UG(0);
      paramInputStream.UG(10);
      paramInputStream.UG(10);
      paramInputStream.UG(0);
      paramInputStream.UG(1);
    }
    ae.d("TAG", "new SPS:".concat(String.valueOf(paramInputStream)));
    AppMethodBeat.o(114847);
    return arrayOfByte;
  }
  
  private boolean N(InputStream paramInputStream)
  {
    AppMethodBeat.i(114849);
    paramInputStream = new j(paramInputStream);
    paramInputStream.UB(8);
    paramInputStream.UB(8);
    paramInputStream.UB(8);
    paramInputStream.UB(8);
    paramInputStream.UB(8);
    int i = (int)paramInputStream.ezq();
    if (i == 66)
    {
      this.CpW |= 0x1;
      AppMethodBeat.o(114849);
      return false;
    }
    paramInputStream.UB(8);
    paramInputStream.ezq();
    paramInputStream.ezs();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.ezt() == 3) {
        paramInputStream.UB(1);
      }
      paramInputStream.ezs();
      paramInputStream.ezs();
      paramInputStream.UB(1);
      if (paramInputStream.tn(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.tn(true))
          {
            if (i >= 6) {
              break label182;
            }
            paramInputStream.UD(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label182:
            paramInputStream.UD(64);
          }
        }
      }
    }
    paramInputStream.ezs();
    i = paramInputStream.ezt();
    if (i == 0) {
      paramInputStream.ezs();
    }
    for (;;)
    {
      if (paramInputStream.ezt() >= 2) {
        this.CpW |= 0x2;
      }
      paramInputStream.UC(1);
      paramInputStream.ezu();
      paramInputStream.ezu();
      if (!paramInputStream.tn(true)) {
        paramInputStream.UC(1);
      }
      paramInputStream.UC(1);
      if (paramInputStream.tn(true))
      {
        paramInputStream.ezu();
        paramInputStream.ezu();
        paramInputStream.ezu();
        paramInputStream.ezu();
      }
      if (!paramInputStream.tn(true)) {
        break;
      }
      ae.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
      if ((paramInputStream.tn(true)) && ((int)paramInputStream.ezq() == 255))
      {
        paramInputStream.UC(16);
        paramInputStream.UC(16);
      }
      if (paramInputStream.tn(true)) {
        paramInputStream.UC(1);
      }
      if (paramInputStream.tn(true))
      {
        paramInputStream.UC(3);
        paramInputStream.UC(1);
        if (paramInputStream.tn(true))
        {
          paramInputStream.UC(8);
          paramInputStream.UC(8);
          paramInputStream.UC(8);
        }
      }
      if (paramInputStream.tn(true))
      {
        paramInputStream.ezu();
        paramInputStream.ezu();
      }
      if (paramInputStream.tn(true))
      {
        paramInputStream.UC(32);
        paramInputStream.UC(32);
        paramInputStream.UC(1);
      }
      boolean bool1 = paramInputStream.tn(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.tn(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.UC(1);
      }
      paramInputStream.UC(1);
      if (!paramInputStream.tn(true)) {
        break;
      }
      paramInputStream.tn(true);
      paramInputStream.ezu();
      paramInputStream.ezu();
      paramInputStream.ezu();
      paramInputStream.ezu();
      i = paramInputStream.ezt();
      int j = paramInputStream.ezt();
      if (i == 0) {
        break;
      }
      ae.d("[H264SPSModifier]", "steve: reorder_frame =" + i + ", mac_dec_buffering=" + j);
      this.CpW |= 0x4;
      AppMethodBeat.o(114849);
      return true;
      if (i == 1)
      {
        paramInputStream.UB(1);
        paramInputStream.ezs();
        paramInputStream.ezs();
        j = paramInputStream.ezt();
        i = 0;
        while (i < j)
        {
          new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
          paramInputStream.ezu();
          i += 1;
        }
      }
    }
    AppMethodBeat.o(114849);
    return false;
  }
  
  private boolean O(InputStream paramInputStream)
  {
    AppMethodBeat.i(114851);
    paramInputStream = new j(paramInputStream);
    paramInputStream.UB(8);
    paramInputStream.UB(8);
    paramInputStream.UB(8);
    paramInputStream.UB(8);
    paramInputStream.UB(8);
    paramInputStream.ezs();
    int i = paramInputStream.ezt();
    ae.d("TAG", "steve:slice_type:".concat(String.valueOf(i)));
    if ((i == 1) || (i == 6))
    {
      this.CpW |= 0x8;
      AppMethodBeat.o(114851);
      return true;
    }
    AppMethodBeat.o(114851);
    return false;
  }
  
  private static void a(j paramj)
  {
    AppMethodBeat.i(114852);
    int j = paramj.ezt();
    paramj.UB(4);
    paramj.UB(4);
    int i = 0;
    while (i <= j)
    {
      paramj.ezs();
      paramj.ezs();
      paramj.UB(1);
      i += 1;
    }
    paramj.UB(5);
    paramj.UB(5);
    paramj.UB(5);
    paramj.UB(5);
    AppMethodBeat.o(114852);
  }
  
  public static byte[] bP(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(209921);
    paramArrayOfByte = M(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(209921);
    return paramArrayOfByte;
  }
  
  public final boolean bQ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114848);
    boolean bool = N(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114848);
    return bool;
  }
  
  public final boolean bR(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114850);
    boolean bool = O(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114850);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.g
 * JD-Core Version:    0.7.0.1
 */