package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class g
{
  public int GTT = 0;
  
  private static byte[] L(InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(114847);
    Object localObject = new ByteArrayOutputStream();
    paramInputStream = new j(paramInputStream, (OutputStream)localObject);
    paramInputStream.acV(8);
    paramInputStream.acV(8);
    paramInputStream.acV(8);
    paramInputStream.acV(8);
    paramInputStream.acV(8);
    int i = (int)paramInputStream.fGg();
    paramInputStream.acV(8);
    paramInputStream.fGg();
    paramInputStream.fGk();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.fGj() == 3) {
        paramInputStream.acV(1);
      }
      paramInputStream.fGk();
      paramInputStream.fGk();
      paramInputStream.acV(1);
      if (paramInputStream.wY(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.wY(true))
          {
            if (i >= 6) {
              break label172;
            }
            paramInputStream.acW(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label172:
            paramInputStream.acW(64);
          }
        }
      }
    }
    paramInputStream.fGk();
    i = paramInputStream.fGj();
    if (i == 0)
    {
      paramInputStream.fGk();
      paramInputStream.fGk();
      paramInputStream.acV(1);
      paramInputStream.fGk();
      paramInputStream.fGk();
      if (!paramInputStream.wY(true)) {
        paramInputStream.acV(1);
      }
      paramInputStream.acV(1);
      if (paramInputStream.wY(true))
      {
        paramInputStream.fGk();
        paramInputStream.fGk();
        paramInputStream.fGk();
        paramInputStream.fGk();
      }
      if (!paramInputStream.wY(false)) {
        break label731;
      }
      Log.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
      paramInputStream.xa(true);
      if ((paramInputStream.wY(true)) && ((int)paramInputStream.fGg() == 255))
      {
        paramInputStream.acV(16);
        paramInputStream.acV(16);
      }
      if (paramInputStream.wY(true)) {
        paramInputStream.acV(1);
      }
      if (paramInputStream.wY(true))
      {
        paramInputStream.acV(3);
        paramInputStream.acV(1);
        if (paramInputStream.wY(true))
        {
          paramInputStream.acV(8);
          paramInputStream.acV(8);
          paramInputStream.acV(8);
        }
      }
      if (paramInputStream.wY(true))
      {
        paramInputStream.fGk();
        paramInputStream.fGk();
      }
      if (paramInputStream.wY(true))
      {
        paramInputStream.acV(32);
        paramInputStream.acV(32);
        paramInputStream.acV(1);
      }
      boolean bool1 = paramInputStream.wY(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.wY(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.acV(1);
      }
      paramInputStream.acV(1);
      if (!paramInputStream.wY(false)) {
        break label679;
      }
      Log.d("TAG", "steve:VUI has bs restriction!!");
      paramInputStream.xa(true);
      paramInputStream.wY(true);
      paramInputStream.fGk();
      paramInputStream.fGk();
      paramInputStream.fGk();
      paramInputStream.fGk();
      paramInputStream.fGk();
      paramInputStream.acZ(1);
    }
    byte[] arrayOfByte;
    for (;;)
    {
      paramInputStream.acX(1);
      paramInputStream.ai(0L, 8 - paramInputStream.GVp);
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
      paramInputStream.acV(1);
      paramInputStream.fGk();
      paramInputStream.fGk();
      int k = paramInputStream.fGj();
      i = 0;
      while (i < k)
      {
        new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
        paramInputStream.fGk();
        i += 1;
      }
      break;
      label679:
      Log.d("TAG", "steve:VUI has NO bs restriction!!");
      paramInputStream.xa(true);
      paramInputStream.xa(true);
      paramInputStream.acZ(0);
      paramInputStream.acZ(0);
      paramInputStream.acZ(10);
      paramInputStream.acZ(10);
      paramInputStream.acZ(0);
      paramInputStream.acZ(1);
      continue;
      label731:
      Log.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
      paramInputStream.xa(true);
      paramInputStream.xa(false);
      paramInputStream.xa(false);
      paramInputStream.xa(false);
      paramInputStream.xa(false);
      paramInputStream.xa(false);
      paramInputStream.xa(false);
      paramInputStream.xa(false);
      paramInputStream.xa(false);
      paramInputStream.xa(true);
      paramInputStream.xa(true);
      paramInputStream.acZ(0);
      paramInputStream.acZ(0);
      paramInputStream.acZ(10);
      paramInputStream.acZ(10);
      paramInputStream.acZ(0);
      paramInputStream.acZ(1);
    }
    Log.d("TAG", "new SPS:".concat(String.valueOf(paramInputStream)));
    AppMethodBeat.o(114847);
    return arrayOfByte;
  }
  
  private boolean M(InputStream paramInputStream)
  {
    AppMethodBeat.i(114849);
    paramInputStream = new j(paramInputStream);
    paramInputStream.acU(8);
    paramInputStream.acU(8);
    paramInputStream.acU(8);
    paramInputStream.acU(8);
    paramInputStream.acU(8);
    int i = (int)paramInputStream.fGg();
    if (i == 66)
    {
      this.GTT |= 0x1;
      AppMethodBeat.o(114849);
      return false;
    }
    paramInputStream.acU(8);
    paramInputStream.fGg();
    paramInputStream.fGi();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.fGj() == 3) {
        paramInputStream.acU(1);
      }
      paramInputStream.fGi();
      paramInputStream.fGi();
      paramInputStream.acU(1);
      if (paramInputStream.wY(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.wY(true))
          {
            if (i >= 6) {
              break label182;
            }
            paramInputStream.acW(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label182:
            paramInputStream.acW(64);
          }
        }
      }
    }
    paramInputStream.fGi();
    i = paramInputStream.fGj();
    if (i == 0) {
      paramInputStream.fGi();
    }
    for (;;)
    {
      if (paramInputStream.fGj() >= 2) {
        this.GTT |= 0x2;
      }
      paramInputStream.acV(1);
      paramInputStream.fGk();
      paramInputStream.fGk();
      if (!paramInputStream.wY(true)) {
        paramInputStream.acV(1);
      }
      paramInputStream.acV(1);
      if (paramInputStream.wY(true))
      {
        paramInputStream.fGk();
        paramInputStream.fGk();
        paramInputStream.fGk();
        paramInputStream.fGk();
      }
      if (!paramInputStream.wY(true)) {
        break;
      }
      Log.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
      if ((paramInputStream.wY(true)) && ((int)paramInputStream.fGg() == 255))
      {
        paramInputStream.acV(16);
        paramInputStream.acV(16);
      }
      if (paramInputStream.wY(true)) {
        paramInputStream.acV(1);
      }
      if (paramInputStream.wY(true))
      {
        paramInputStream.acV(3);
        paramInputStream.acV(1);
        if (paramInputStream.wY(true))
        {
          paramInputStream.acV(8);
          paramInputStream.acV(8);
          paramInputStream.acV(8);
        }
      }
      if (paramInputStream.wY(true))
      {
        paramInputStream.fGk();
        paramInputStream.fGk();
      }
      if (paramInputStream.wY(true))
      {
        paramInputStream.acV(32);
        paramInputStream.acV(32);
        paramInputStream.acV(1);
      }
      boolean bool1 = paramInputStream.wY(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.wY(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.acV(1);
      }
      paramInputStream.acV(1);
      if (!paramInputStream.wY(true)) {
        break;
      }
      paramInputStream.wY(true);
      paramInputStream.fGk();
      paramInputStream.fGk();
      paramInputStream.fGk();
      paramInputStream.fGk();
      i = paramInputStream.fGj();
      int j = paramInputStream.fGj();
      if (i == 0) {
        break;
      }
      Log.d("[H264SPSModifier]", "steve: reorder_frame =" + i + ", mac_dec_buffering=" + j);
      this.GTT |= 0x4;
      AppMethodBeat.o(114849);
      return true;
      if (i == 1)
      {
        paramInputStream.acU(1);
        paramInputStream.fGi();
        paramInputStream.fGi();
        j = paramInputStream.fGj();
        i = 0;
        while (i < j)
        {
          new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
          paramInputStream.fGk();
          i += 1;
        }
      }
    }
    AppMethodBeat.o(114849);
    return false;
  }
  
  private boolean N(InputStream paramInputStream)
  {
    AppMethodBeat.i(114851);
    paramInputStream = new j(paramInputStream);
    paramInputStream.acU(8);
    paramInputStream.acU(8);
    paramInputStream.acU(8);
    paramInputStream.acU(8);
    paramInputStream.acU(8);
    paramInputStream.fGi();
    int i = paramInputStream.fGj();
    Log.d("TAG", "steve:slice_type:".concat(String.valueOf(i)));
    if ((i == 1) || (i == 6))
    {
      this.GTT |= 0x8;
      AppMethodBeat.o(114851);
      return true;
    }
    AppMethodBeat.o(114851);
    return false;
  }
  
  private static void a(j paramj)
  {
    AppMethodBeat.i(114852);
    int j = paramj.fGj();
    paramj.acU(4);
    paramj.acU(4);
    int i = 0;
    while (i <= j)
    {
      paramj.fGi();
      paramj.fGi();
      paramj.acU(1);
      i += 1;
    }
    paramj.acU(5);
    paramj.acU(5);
    paramj.acU(5);
    paramj.acU(5);
    AppMethodBeat.o(114852);
  }
  
  public final byte[] cf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(235484);
    paramArrayOfByte = L(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(235484);
    return paramArrayOfByte;
  }
  
  public final boolean cg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114848);
    boolean bool = M(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114848);
    return bool;
  }
  
  public final boolean ch(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114850);
    boolean bool = N(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114850);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.g
 * JD-Core Version:    0.7.0.1
 */