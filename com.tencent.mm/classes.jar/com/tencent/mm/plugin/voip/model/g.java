package com.tencent.mm.plugin.voip.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public final class g
{
  public int Azv = 0;
  
  public static byte[] J(InputStream paramInputStream)
  {
    int j = 0;
    AppMethodBeat.i(114847);
    Object localObject = new ByteArrayOutputStream();
    paramInputStream = new j(paramInputStream, (OutputStream)localObject);
    paramInputStream.Sd(8);
    paramInputStream.Sd(8);
    paramInputStream.Sd(8);
    paramInputStream.Sd(8);
    paramInputStream.Sd(8);
    int i = (int)paramInputStream.ehY();
    paramInputStream.Sd(8);
    paramInputStream.ehY();
    paramInputStream.eic();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.eib() == 3) {
        paramInputStream.Sd(1);
      }
      paramInputStream.eic();
      paramInputStream.eic();
      paramInputStream.Sd(1);
      if (paramInputStream.sx(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.sx(true))
          {
            if (i >= 6) {
              break label172;
            }
            paramInputStream.Se(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label172:
            paramInputStream.Se(64);
          }
        }
      }
    }
    paramInputStream.eic();
    i = paramInputStream.eib();
    if (i == 0)
    {
      paramInputStream.eic();
      paramInputStream.eic();
      paramInputStream.Sd(1);
      paramInputStream.eic();
      paramInputStream.eic();
      if (!paramInputStream.sx(true)) {
        paramInputStream.Sd(1);
      }
      paramInputStream.Sd(1);
      if (paramInputStream.sx(true))
      {
        paramInputStream.eic();
        paramInputStream.eic();
        paramInputStream.eic();
        paramInputStream.eic();
      }
      if (!paramInputStream.sx(false)) {
        break label731;
      }
      ac.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
      paramInputStream.sz(true);
      if ((paramInputStream.sx(true)) && ((int)paramInputStream.ehY() == 255))
      {
        paramInputStream.Sd(16);
        paramInputStream.Sd(16);
      }
      if (paramInputStream.sx(true)) {
        paramInputStream.Sd(1);
      }
      if (paramInputStream.sx(true))
      {
        paramInputStream.Sd(3);
        paramInputStream.Sd(1);
        if (paramInputStream.sx(true))
        {
          paramInputStream.Sd(8);
          paramInputStream.Sd(8);
          paramInputStream.Sd(8);
        }
      }
      if (paramInputStream.sx(true))
      {
        paramInputStream.eic();
        paramInputStream.eic();
      }
      if (paramInputStream.sx(true))
      {
        paramInputStream.Sd(32);
        paramInputStream.Sd(32);
        paramInputStream.Sd(1);
      }
      boolean bool1 = paramInputStream.sx(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.sx(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.Sd(1);
      }
      paramInputStream.Sd(1);
      if (!paramInputStream.sx(false)) {
        break label679;
      }
      ac.d("TAG", "steve:VUI has bs restriction!!");
      paramInputStream.sz(true);
      paramInputStream.sx(true);
      paramInputStream.eic();
      paramInputStream.eic();
      paramInputStream.eic();
      paramInputStream.eic();
      paramInputStream.eic();
      paramInputStream.Sh(1);
    }
    byte[] arrayOfByte;
    for (;;)
    {
      paramInputStream.Sf(1);
      paramInputStream.aa(0L, 8 - paramInputStream.ABd);
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
      paramInputStream.Sd(1);
      paramInputStream.eic();
      paramInputStream.eic();
      int k = paramInputStream.eib();
      i = 0;
      while (i < k)
      {
        new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
        paramInputStream.eic();
        i += 1;
      }
      break;
      label679:
      ac.d("TAG", "steve:VUI has NO bs restriction!!");
      paramInputStream.sz(true);
      paramInputStream.sz(true);
      paramInputStream.Sh(0);
      paramInputStream.Sh(0);
      paramInputStream.Sh(10);
      paramInputStream.Sh(10);
      paramInputStream.Sh(0);
      paramInputStream.Sh(1);
      continue;
      label731:
      ac.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
      paramInputStream.sz(true);
      paramInputStream.sz(false);
      paramInputStream.sz(false);
      paramInputStream.sz(false);
      paramInputStream.sz(false);
      paramInputStream.sz(false);
      paramInputStream.sz(false);
      paramInputStream.sz(false);
      paramInputStream.sz(false);
      paramInputStream.sz(true);
      paramInputStream.sz(true);
      paramInputStream.Sh(0);
      paramInputStream.Sh(0);
      paramInputStream.Sh(10);
      paramInputStream.Sh(10);
      paramInputStream.Sh(0);
      paramInputStream.Sh(1);
    }
    ac.d("TAG", "new SPS:".concat(String.valueOf(paramInputStream)));
    AppMethodBeat.o(114847);
    return arrayOfByte;
  }
  
  private boolean K(InputStream paramInputStream)
  {
    AppMethodBeat.i(114849);
    paramInputStream = new j(paramInputStream);
    paramInputStream.Sc(8);
    paramInputStream.Sc(8);
    paramInputStream.Sc(8);
    paramInputStream.Sc(8);
    paramInputStream.Sc(8);
    int i = (int)paramInputStream.ehY();
    if (i == 66)
    {
      this.Azv |= 0x1;
      AppMethodBeat.o(114849);
      return false;
    }
    paramInputStream.Sc(8);
    paramInputStream.ehY();
    paramInputStream.eia();
    if ((i == 100) || (i == 110) || (i == 122) || (i == 144))
    {
      if (paramInputStream.eib() == 3) {
        paramInputStream.Sc(1);
      }
      paramInputStream.eia();
      paramInputStream.eia();
      paramInputStream.Sc(1);
      if (paramInputStream.sx(true))
      {
        i = 0;
        if (i < 8)
        {
          if (paramInputStream.sx(true))
          {
            if (i >= 6) {
              break label182;
            }
            paramInputStream.Se(16);
          }
          for (;;)
          {
            i += 1;
            break;
            label182:
            paramInputStream.Se(64);
          }
        }
      }
    }
    paramInputStream.eia();
    i = paramInputStream.eib();
    if (i == 0) {
      paramInputStream.eia();
    }
    for (;;)
    {
      if (paramInputStream.eib() >= 2) {
        this.Azv |= 0x2;
      }
      paramInputStream.Sd(1);
      paramInputStream.eic();
      paramInputStream.eic();
      if (!paramInputStream.sx(true)) {
        paramInputStream.Sd(1);
      }
      paramInputStream.Sd(1);
      if (paramInputStream.sx(true))
      {
        paramInputStream.eic();
        paramInputStream.eic();
        paramInputStream.eic();
        paramInputStream.eic();
      }
      if (!paramInputStream.sx(true)) {
        break;
      }
      ac.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
      if ((paramInputStream.sx(true)) && ((int)paramInputStream.ehY() == 255))
      {
        paramInputStream.Sd(16);
        paramInputStream.Sd(16);
      }
      if (paramInputStream.sx(true)) {
        paramInputStream.Sd(1);
      }
      if (paramInputStream.sx(true))
      {
        paramInputStream.Sd(3);
        paramInputStream.Sd(1);
        if (paramInputStream.sx(true))
        {
          paramInputStream.Sd(8);
          paramInputStream.Sd(8);
          paramInputStream.Sd(8);
        }
      }
      if (paramInputStream.sx(true))
      {
        paramInputStream.eic();
        paramInputStream.eic();
      }
      if (paramInputStream.sx(true))
      {
        paramInputStream.Sd(32);
        paramInputStream.Sd(32);
        paramInputStream.Sd(1);
      }
      boolean bool1 = paramInputStream.sx(true);
      if (bool1) {
        a(paramInputStream);
      }
      boolean bool2 = paramInputStream.sx(true);
      if (bool2) {
        a(paramInputStream);
      }
      if ((bool1) || (bool2)) {
        paramInputStream.Sd(1);
      }
      paramInputStream.Sd(1);
      if (!paramInputStream.sx(true)) {
        break;
      }
      paramInputStream.sx(true);
      paramInputStream.eic();
      paramInputStream.eic();
      paramInputStream.eic();
      paramInputStream.eic();
      i = paramInputStream.eib();
      int j = paramInputStream.eib();
      if (i == 0) {
        break;
      }
      ac.d("[H264SPSModifier]", "steve: reorder_frame =" + i + ", mac_dec_buffering=" + j);
      this.Azv |= 0x4;
      AppMethodBeat.o(114849);
      return true;
      if (i == 1)
      {
        paramInputStream.Sc(1);
        paramInputStream.eia();
        paramInputStream.eia();
        j = paramInputStream.eib();
        i = 0;
        while (i < j)
        {
          new StringBuilder("SPS: offsetForRefFrame [").append(i).append("]");
          paramInputStream.eic();
          i += 1;
        }
      }
    }
    AppMethodBeat.o(114849);
    return false;
  }
  
  private boolean L(InputStream paramInputStream)
  {
    AppMethodBeat.i(114851);
    paramInputStream = new j(paramInputStream);
    paramInputStream.Sc(8);
    paramInputStream.Sc(8);
    paramInputStream.Sc(8);
    paramInputStream.Sc(8);
    paramInputStream.Sc(8);
    paramInputStream.eia();
    int i = paramInputStream.eib();
    ac.d("TAG", "steve:slice_type:".concat(String.valueOf(i)));
    if ((i == 1) || (i == 6))
    {
      this.Azv |= 0x8;
      AppMethodBeat.o(114851);
      return true;
    }
    AppMethodBeat.o(114851);
    return false;
  }
  
  private static void a(j paramj)
  {
    AppMethodBeat.i(114852);
    int j = paramj.eib();
    paramj.Sc(4);
    paramj.Sc(4);
    int i = 0;
    while (i <= j)
    {
      paramj.eia();
      paramj.eia();
      paramj.Sc(1);
      i += 1;
    }
    paramj.Sc(5);
    paramj.Sc(5);
    paramj.Sc(5);
    paramj.Sc(5);
    AppMethodBeat.o(114852);
  }
  
  public final boolean bG(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114848);
    boolean bool = K(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114848);
    return bool;
  }
  
  public final boolean bH(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(114850);
    boolean bool = L(new ByteArrayInputStream(paramArrayOfByte));
    AppMethodBeat.o(114850);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.g
 * JD-Core Version:    0.7.0.1
 */