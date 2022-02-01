package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dye
  extends cpx
{
  public String GbJ;
  public String Gej;
  public int Gek;
  public int Gel;
  public String Gem;
  public int Gen;
  public String Geo;
  public String Gep;
  public String djj;
  public String dkm;
  public String nHD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82489);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dkm != null) {
        paramVarArgs.d(2, this.dkm);
      }
      if (this.Gej != null) {
        paramVarArgs.d(3, this.Gej);
      }
      paramVarArgs.aR(4, this.Gek);
      paramVarArgs.aR(5, this.Gel);
      if (this.GbJ != null) {
        paramVarArgs.d(6, this.GbJ);
      }
      if (this.nHD != null) {
        paramVarArgs.d(7, this.nHD);
      }
      if (this.djj != null) {
        paramVarArgs.d(8, this.djj);
      }
      if (this.Gem != null) {
        paramVarArgs.d(9, this.Gem);
      }
      paramVarArgs.aR(10, this.Gen);
      if (this.Geo != null) {
        paramVarArgs.d(11, this.Geo);
      }
      if (this.Gep != null) {
        paramVarArgs.d(12, this.Gep);
      }
      AppMethodBeat.o(82489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label934;
      }
    }
    label934:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dkm != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dkm);
      }
      i = paramInt;
      if (this.Gej != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gej);
      }
      i = i + f.a.a.b.b.a.bx(4, this.Gek) + f.a.a.b.b.a.bx(5, this.Gel);
      paramInt = i;
      if (this.GbJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GbJ);
      }
      i = paramInt;
      if (this.nHD != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.nHD);
      }
      paramInt = i;
      if (this.djj != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.djj);
      }
      i = paramInt;
      if (this.Gem != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Gem);
      }
      i += f.a.a.b.b.a.bx(10, this.Gen);
      paramInt = i;
      if (this.Geo != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Geo);
      }
      i = paramInt;
      if (this.Gep != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Gep);
      }
      AppMethodBeat.o(82489);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(82489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dye localdye = (dye)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82489);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdye.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82489);
          return 0;
        case 2: 
          localdye.dkm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 3: 
          localdye.Gej = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 4: 
          localdye.Gek = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82489);
          return 0;
        case 5: 
          localdye.Gel = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82489);
          return 0;
        case 6: 
          localdye.GbJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 7: 
          localdye.nHD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 8: 
          localdye.djj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 9: 
          localdye.Gem = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82489);
          return 0;
        case 10: 
          localdye.Gen = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(82489);
          return 0;
        case 11: 
          localdye.Geo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(82489);
          return 0;
        }
        localdye.Gep = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(82489);
        return 0;
      }
      AppMethodBeat.o(82489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dye
 * JD-Core Version:    0.7.0.1
 */