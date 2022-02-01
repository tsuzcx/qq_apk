package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arg
  extends com.tencent.mm.bx.a
{
  public String EYP;
  public String GoZ;
  public String Gpa;
  public int Gpb;
  public int Gpc;
  public String Gpd;
  public String Gpe;
  public aoo Gpf;
  public aok Gpg;
  public int ilN;
  public String oLa;
  public art rIn;
  public int recommendType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209357);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oLa != null) {
        paramVarArgs.d(1, this.oLa);
      }
      if (this.GoZ != null) {
        paramVarArgs.d(2, this.GoZ);
      }
      if (this.Gpa != null) {
        paramVarArgs.d(3, this.Gpa);
      }
      paramVarArgs.aS(4, this.Gpb);
      paramVarArgs.aS(5, this.Gpc);
      if (this.Gpd != null) {
        paramVarArgs.d(6, this.Gpd);
      }
      if (this.Gpe != null) {
        paramVarArgs.d(7, this.Gpe);
      }
      if (this.EYP != null) {
        paramVarArgs.d(8, this.EYP);
      }
      paramVarArgs.aS(9, this.ilN);
      if (this.Gpf != null)
      {
        paramVarArgs.lC(10, this.Gpf.computeSize());
        this.Gpf.writeFields(paramVarArgs);
      }
      if (this.rIn != null)
      {
        paramVarArgs.lC(11, this.rIn.computeSize());
        this.rIn.writeFields(paramVarArgs);
      }
      if (this.Gpg != null)
      {
        paramVarArgs.lC(12, this.Gpg.computeSize());
        this.Gpg.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.recommendType);
      AppMethodBeat.o(209357);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oLa == null) {
        break label1170;
      }
    }
    label1170:
    for (int i = f.a.a.b.b.a.e(1, this.oLa) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GoZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GoZ);
      }
      i = paramInt;
      if (this.Gpa != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Gpa);
      }
      i = i + f.a.a.b.b.a.bz(4, this.Gpb) + f.a.a.b.b.a.bz(5, this.Gpc);
      paramInt = i;
      if (this.Gpd != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gpd);
      }
      i = paramInt;
      if (this.Gpe != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gpe);
      }
      paramInt = i;
      if (this.EYP != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EYP);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.ilN);
      paramInt = i;
      if (this.Gpf != null) {
        paramInt = i + f.a.a.a.lB(10, this.Gpf.computeSize());
      }
      i = paramInt;
      if (this.rIn != null) {
        i = paramInt + f.a.a.a.lB(11, this.rIn.computeSize());
      }
      paramInt = i;
      if (this.Gpg != null) {
        paramInt = i + f.a.a.a.lB(12, this.Gpg.computeSize());
      }
      i = f.a.a.b.b.a.bz(13, this.recommendType);
      AppMethodBeat.o(209357);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(209357);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arg localarg = (arg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209357);
          return -1;
        case 1: 
          localarg.oLa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209357);
          return 0;
        case 2: 
          localarg.GoZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209357);
          return 0;
        case 3: 
          localarg.Gpa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209357);
          return 0;
        case 4: 
          localarg.Gpb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209357);
          return 0;
        case 5: 
          localarg.Gpc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209357);
          return 0;
        case 6: 
          localarg.Gpd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209357);
          return 0;
        case 7: 
          localarg.Gpe = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209357);
          return 0;
        case 8: 
          localarg.EYP = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(209357);
          return 0;
        case 9: 
          localarg.ilN = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(209357);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aoo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aoo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarg.Gpf = ((aoo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209357);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new art();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((art)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarg.rIn = ((art)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209357);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aok();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aok)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarg.Gpg = ((aok)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209357);
          return 0;
        }
        localarg.recommendType = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(209357);
        return 0;
      }
      AppMethodBeat.o(209357);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arg
 * JD-Core Version:    0.7.0.1
 */