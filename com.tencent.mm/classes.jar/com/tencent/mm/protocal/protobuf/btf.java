package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btf
  extends cvc
{
  public int GDf;
  public boolean GFK;
  public boolean GFL;
  public ehq GNA;
  public egs GNB;
  public eip GNC;
  public ehj GND;
  public ehr GNE;
  public int GNF;
  public String GNG;
  public String GNH;
  public ehs GNI;
  public eft GNz;
  public String iht;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123624);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      if (this.GNz != null)
      {
        paramVarArgs.lC(3, this.GNz.computeSize());
        this.GNz.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.GDf);
      if (this.GNA != null)
      {
        paramVarArgs.lC(5, this.GNA.computeSize());
        this.GNA.writeFields(paramVarArgs);
      }
      if (this.GNB != null)
      {
        paramVarArgs.lC(6, this.GNB.computeSize());
        this.GNB.writeFields(paramVarArgs);
      }
      if (this.GNC != null)
      {
        paramVarArgs.lC(7, this.GNC.computeSize());
        this.GNC.writeFields(paramVarArgs);
      }
      if (this.GND != null)
      {
        paramVarArgs.lC(8, this.GND.computeSize());
        this.GND.writeFields(paramVarArgs);
      }
      if (this.GNE != null)
      {
        paramVarArgs.lC(9, this.GNE.computeSize());
        this.GNE.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.GNF);
      if (this.GNG != null) {
        paramVarArgs.d(11, this.GNG);
      }
      if (this.GNH != null) {
        paramVarArgs.d(12, this.GNH);
      }
      paramVarArgs.bt(13, this.GFK);
      paramVarArgs.bt(14, this.GFL);
      if (this.GNI != null)
      {
        paramVarArgs.lC(15, this.GNI.computeSize());
        this.GNI.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123624);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1754;
      }
    }
    label1754:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iht != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.iht);
      }
      i = paramInt;
      if (this.GNz != null) {
        i = paramInt + f.a.a.a.lB(3, this.GNz.computeSize());
      }
      i += f.a.a.b.b.a.bz(4, this.GDf);
      paramInt = i;
      if (this.GNA != null) {
        paramInt = i + f.a.a.a.lB(5, this.GNA.computeSize());
      }
      i = paramInt;
      if (this.GNB != null) {
        i = paramInt + f.a.a.a.lB(6, this.GNB.computeSize());
      }
      paramInt = i;
      if (this.GNC != null) {
        paramInt = i + f.a.a.a.lB(7, this.GNC.computeSize());
      }
      i = paramInt;
      if (this.GND != null) {
        i = paramInt + f.a.a.a.lB(8, this.GND.computeSize());
      }
      paramInt = i;
      if (this.GNE != null) {
        paramInt = i + f.a.a.a.lB(9, this.GNE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.GNF);
      paramInt = i;
      if (this.GNG != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.GNG);
      }
      i = paramInt;
      if (this.GNH != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.GNH);
      }
      i = i + f.a.a.b.b.a.alV(13) + f.a.a.b.b.a.alV(14);
      paramInt = i;
      if (this.GNI != null) {
        paramInt = i + f.a.a.a.lB(15, this.GNI.computeSize());
      }
      AppMethodBeat.o(123624);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        btf localbtf = (btf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123624);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtf.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 2: 
          localbtf.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eft();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eft)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtf.GNz = ((eft)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 4: 
          localbtf.GDf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123624);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtf.GNA = ((ehq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtf.GNB = ((egs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtf.GNC = ((eip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtf.GND = ((ehj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtf.GNE = ((ehr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123624);
          return 0;
        case 10: 
          localbtf.GNF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123624);
          return 0;
        case 11: 
          localbtf.GNG = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 12: 
          localbtf.GNH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123624);
          return 0;
        case 13: 
          localbtf.GFK = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(123624);
          return 0;
        case 14: 
          localbtf.GFL = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(123624);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ehs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ehs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbtf.GNI = ((ehs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123624);
        return 0;
      }
      AppMethodBeat.o(123624);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btf
 * JD-Core Version:    0.7.0.1
 */