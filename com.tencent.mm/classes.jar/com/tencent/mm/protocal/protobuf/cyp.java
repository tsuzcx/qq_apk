package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyp
  extends com.tencent.mm.bx.a
{
  public String FVo;
  public String FVp;
  public String GaA;
  public String Gaz;
  public String Guj;
  public cew HpC;
  public int Hpn;
  public String iht;
  public int jdc;
  public String nDo;
  public String nEt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152685);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.nDo != null) {
        paramVarArgs.d(1, this.nDo);
      }
      if (this.nEt != null) {
        paramVarArgs.d(2, this.nEt);
      }
      if (this.Gaz != null) {
        paramVarArgs.d(3, this.Gaz);
      }
      if (this.GaA != null) {
        paramVarArgs.d(4, this.GaA);
      }
      paramVarArgs.aS(5, this.jdc);
      if (this.FVo != null) {
        paramVarArgs.d(6, this.FVo);
      }
      if (this.FVp != null) {
        paramVarArgs.d(7, this.FVp);
      }
      if (this.iht != null) {
        paramVarArgs.d(8, this.iht);
      }
      paramVarArgs.aS(9, this.Hpn);
      if (this.HpC != null)
      {
        paramVarArgs.lC(10, this.HpC.computeSize());
        this.HpC.writeFields(paramVarArgs);
      }
      if (this.Guj != null) {
        paramVarArgs.d(11, this.Guj);
      }
      AppMethodBeat.o(152685);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nDo == null) {
        break label890;
      }
    }
    label890:
    for (int i = f.a.a.b.b.a.e(1, this.nDo) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nEt != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nEt);
      }
      i = paramInt;
      if (this.Gaz != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gaz);
      }
      paramInt = i;
      if (this.GaA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GaA);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.jdc);
      paramInt = i;
      if (this.FVo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FVo);
      }
      i = paramInt;
      if (this.FVp != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FVp);
      }
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.iht);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.Hpn);
      paramInt = i;
      if (this.HpC != null) {
        paramInt = i + f.a.a.a.lB(10, this.HpC.computeSize());
      }
      i = paramInt;
      if (this.Guj != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.Guj);
      }
      AppMethodBeat.o(152685);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152685);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cyp localcyp = (cyp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152685);
          return -1;
        case 1: 
          localcyp.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 2: 
          localcyp.nEt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 3: 
          localcyp.Gaz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 4: 
          localcyp.GaA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 5: 
          localcyp.jdc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152685);
          return 0;
        case 6: 
          localcyp.FVo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 7: 
          localcyp.FVp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 8: 
          localcyp.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152685);
          return 0;
        case 9: 
          localcyp.Hpn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152685);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cew();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cew)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcyp.HpC = ((cew)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152685);
          return 0;
        }
        localcyp.Guj = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152685);
        return 0;
      }
      AppMethodBeat.o(152685);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyp
 * JD-Core Version:    0.7.0.1
 */