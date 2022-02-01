package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhc
  extends erp
{
  public int YIq;
  public gol YKa;
  public gol YKb;
  public float ZaG;
  public float ZaH;
  public int Zyl;
  public String Zym;
  public String Zyn;
  public int Zyo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89926);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIq);
      paramVarArgs.l(3, this.ZaG);
      paramVarArgs.l(4, this.ZaH);
      paramVarArgs.bS(5, this.Zyl);
      if (this.Zym != null) {
        paramVarArgs.g(6, this.Zym);
      }
      if (this.Zyn != null) {
        paramVarArgs.g(7, this.Zyn);
      }
      paramVarArgs.bS(8, this.Zyo);
      if (this.YKa != null)
      {
        paramVarArgs.qD(9, this.YKa.computeSize());
        this.YKa.writeFields(paramVarArgs);
      }
      if (this.YKb != null)
      {
        paramVarArgs.qD(10, this.YKb.computeSize());
        this.YKb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(89926);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIq) + (i.a.a.b.b.a.ko(3) + 4) + (i.a.a.b.b.a.ko(4) + 4) + i.a.a.b.b.a.cJ(5, this.Zyl);
      paramInt = i;
      if (this.Zym != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zym);
      }
      i = paramInt;
      if (this.Zyn != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Zyn);
      }
      i += i.a.a.b.b.a.cJ(8, this.Zyo);
      paramInt = i;
      if (this.YKa != null) {
        paramInt = i + i.a.a.a.qC(9, this.YKa.computeSize());
      }
      i = paramInt;
      if (this.YKb != null) {
        i = paramInt + i.a.a.a.qC(10, this.YKb.computeSize());
      }
      AppMethodBeat.o(89926);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(89926);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dhc localdhc = (dhc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89926);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localdhc.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89926);
          return 0;
        case 2: 
          localdhc.YIq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89926);
          return 0;
        case 3: 
          localdhc.ZaG = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(89926);
          return 0;
        case 4: 
          localdhc.ZaH = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
          AppMethodBeat.o(89926);
          return 0;
        case 5: 
          localdhc.Zyl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89926);
          return 0;
        case 6: 
          localdhc.Zym = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89926);
          return 0;
        case 7: 
          localdhc.Zyn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(89926);
          return 0;
        case 8: 
          localdhc.Zyo = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(89926);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localdhc.YKa = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(89926);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localdhc.YKb = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(89926);
        return 0;
      }
      AppMethodBeat.o(89926);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhc
 * JD-Core Version:    0.7.0.1
 */