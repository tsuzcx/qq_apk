package com.tencent.mm.plugin.wallet.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class q
  extends com.tencent.mm.bx.a
{
  public String MEo;
  public String Vlr;
  public String Vls;
  public String Vlt;
  public int Vmm;
  public int Vmn;
  public long Vmo;
  public String Vmp;
  public String Vmq;
  public String Vmr;
  public double Vms;
  public double Vmt;
  public int Vmu;
  public String Vmv;
  public String Vmw;
  public LinkedList<b> Vmx;
  
  public q()
  {
    AppMethodBeat.i(91304);
    this.Vmx = new LinkedList();
    AppMethodBeat.o(91304);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91305);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Vmm);
      paramVarArgs.bS(2, this.Vmn);
      paramVarArgs.bv(3, this.Vmo);
      if (this.Vmp != null) {
        paramVarArgs.g(4, this.Vmp);
      }
      if (this.Vlr != null) {
        paramVarArgs.g(5, this.Vlr);
      }
      if (this.Vmq != null) {
        paramVarArgs.g(6, this.Vmq);
      }
      if (this.Vmr != null) {
        paramVarArgs.g(7, this.Vmr);
      }
      if (this.Vls != null) {
        paramVarArgs.g(8, this.Vls);
      }
      if (this.Vlt != null) {
        paramVarArgs.g(9, this.Vlt);
      }
      paramVarArgs.d(10, this.Vms);
      paramVarArgs.d(11, this.Vmt);
      paramVarArgs.bS(12, this.Vmu);
      if (this.Vmv != null) {
        paramVarArgs.g(13, this.Vmv);
      }
      if (this.MEo != null) {
        paramVarArgs.g(14, this.MEo);
      }
      if (this.Vmw != null) {
        paramVarArgs.g(16, this.Vmw);
      }
      paramVarArgs.e(17, 6, this.Vmx);
      AppMethodBeat.o(91305);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Vmm) + 0 + i.a.a.b.b.a.cJ(2, this.Vmn) + i.a.a.b.b.a.q(3, this.Vmo);
      paramInt = i;
      if (this.Vmp != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Vmp);
      }
      i = paramInt;
      if (this.Vlr != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Vlr);
      }
      paramInt = i;
      if (this.Vmq != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Vmq);
      }
      i = paramInt;
      if (this.Vmr != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Vmr);
      }
      paramInt = i;
      if (this.Vls != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Vls);
      }
      i = paramInt;
      if (this.Vlt != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.Vlt);
      }
      i = i + (i.a.a.b.b.a.ko(10) + 8) + (i.a.a.b.b.a.ko(11) + 8) + i.a.a.b.b.a.cJ(12, this.Vmu);
      paramInt = i;
      if (this.Vmv != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.Vmv);
      }
      i = paramInt;
      if (this.MEo != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.MEo);
      }
      paramInt = i;
      if (this.Vmw != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.Vmw);
      }
      i = i.a.a.a.c(17, 6, this.Vmx);
      AppMethodBeat.o(91305);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Vmx.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91305);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      q localq = (q)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 15: 
      default: 
        AppMethodBeat.o(91305);
        return -1;
      case 1: 
        localq.Vmm = locala.ajGk.aar();
        AppMethodBeat.o(91305);
        return 0;
      case 2: 
        localq.Vmn = locala.ajGk.aar();
        AppMethodBeat.o(91305);
        return 0;
      case 3: 
        localq.Vmo = locala.ajGk.aaw();
        AppMethodBeat.o(91305);
        return 0;
      case 4: 
        localq.Vmp = locala.ajGk.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 5: 
        localq.Vlr = locala.ajGk.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 6: 
        localq.Vmq = locala.ajGk.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 7: 
        localq.Vmr = locala.ajGk.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 8: 
        localq.Vls = locala.ajGk.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 9: 
        localq.Vlt = locala.ajGk.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 10: 
        localq.Vms = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(91305);
        return 0;
      case 11: 
        localq.Vmt = Double.longBitsToDouble(locala.ajGk.aay());
        AppMethodBeat.o(91305);
        return 0;
      case 12: 
        localq.Vmu = locala.ajGk.aar();
        AppMethodBeat.o(91305);
        return 0;
      case 13: 
        localq.Vmv = locala.ajGk.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 14: 
        localq.MEo = locala.ajGk.readString();
        AppMethodBeat.o(91305);
        return 0;
      case 16: 
        localq.Vmw = locala.ajGk.readString();
        AppMethodBeat.o(91305);
        return 0;
      }
      localq.Vmx.add(locala.ajGk.kFX());
      AppMethodBeat.o(91305);
      return 0;
    }
    AppMethodBeat.o(91305);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.model.q
 * JD-Core Version:    0.7.0.1
 */