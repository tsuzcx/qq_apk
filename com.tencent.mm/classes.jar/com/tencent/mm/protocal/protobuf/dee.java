package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dee
  extends cvp
{
  public String GXm;
  public he HqD;
  public String HsA;
  public hg HsB;
  public LinkedList<hg> HsC;
  public dvj HsD;
  public boolean HsE;
  public String HsF;
  public hc HsG;
  public int Hsv;
  public hd Hsw;
  public String Hsx;
  public LinkedList<hf> Hsy;
  public String Hsz;
  public String dpf;
  public String hBg;
  public String title;
  
  public dee()
  {
    AppMethodBeat.i(123652);
    this.Hsy = new LinkedList();
    this.HsC = new LinkedList();
    AppMethodBeat.o(123652);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123653);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123653);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.HqD != null)
      {
        paramVarArgs.lC(2, this.HqD.computeSize());
        this.HqD.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Hsv);
      if (this.Hsw != null)
      {
        paramVarArgs.lC(4, this.Hsw.computeSize());
        this.Hsw.writeFields(paramVarArgs);
      }
      if (this.title != null) {
        paramVarArgs.d(5, this.title);
      }
      if (this.GXm != null) {
        paramVarArgs.d(6, this.GXm);
      }
      if (this.hBg != null) {
        paramVarArgs.d(7, this.hBg);
      }
      if (this.Hsx != null) {
        paramVarArgs.d(8, this.Hsx);
      }
      paramVarArgs.e(9, 8, this.Hsy);
      if (this.Hsz != null) {
        paramVarArgs.d(10, this.Hsz);
      }
      if (this.HsA != null) {
        paramVarArgs.d(11, this.HsA);
      }
      if (this.HsB != null)
      {
        paramVarArgs.lC(12, this.HsB.computeSize());
        this.HsB.writeFields(paramVarArgs);
      }
      paramVarArgs.e(13, 8, this.HsC);
      if (this.dpf != null) {
        paramVarArgs.d(14, this.dpf);
      }
      if (this.HsD != null)
      {
        paramVarArgs.lC(15, this.HsD.computeSize());
        this.HsD.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(16, this.HsE);
      if (this.HsF != null) {
        paramVarArgs.d(17, this.HsF);
      }
      if (this.HsG != null)
      {
        paramVarArgs.lC(19, this.HsG.computeSize());
        this.HsG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123653);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2002;
      }
    }
    label2002:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HqD != null) {
        i = paramInt + f.a.a.a.lB(2, this.HqD.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.Hsv);
      paramInt = i;
      if (this.Hsw != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hsw.computeSize());
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.title);
      }
      paramInt = i;
      if (this.GXm != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GXm);
      }
      i = paramInt;
      if (this.hBg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hBg);
      }
      paramInt = i;
      if (this.Hsx != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Hsx);
      }
      i = paramInt + f.a.a.a.c(9, 8, this.Hsy);
      paramInt = i;
      if (this.Hsz != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Hsz);
      }
      i = paramInt;
      if (this.HsA != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.HsA);
      }
      paramInt = i;
      if (this.HsB != null) {
        paramInt = i + f.a.a.a.lB(12, this.HsB.computeSize());
      }
      i = paramInt + f.a.a.a.c(13, 8, this.HsC);
      paramInt = i;
      if (this.dpf != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.dpf);
      }
      i = paramInt;
      if (this.HsD != null) {
        i = paramInt + f.a.a.a.lB(15, this.HsD.computeSize());
      }
      i += f.a.a.b.b.a.alV(16);
      paramInt = i;
      if (this.HsF != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.HsF);
      }
      i = paramInt;
      if (this.HsG != null) {
        i = paramInt + f.a.a.a.lB(19, this.HsG.computeSize());
      }
      AppMethodBeat.o(123653);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hsy.clear();
        this.HsC.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123653);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dee localdee = (dee)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        default: 
          AppMethodBeat.o(123653);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdee.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new he();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((he)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdee.HqD = ((he)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 3: 
          localdee.Hsv = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123653);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hd();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdee.Hsw = ((hd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 5: 
          localdee.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 6: 
          localdee.GXm = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 7: 
          localdee.hBg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 8: 
          localdee.Hsx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdee.Hsy.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 10: 
          localdee.Hsz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 11: 
          localdee.HsA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdee.HsB = ((hg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 13: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdee.HsC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 14: 
          localdee.dpf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123653);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dvj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dvj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdee.HsD = ((dvj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123653);
          return 0;
        case 16: 
          localdee.HsE = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(123653);
          return 0;
        case 17: 
          localdee.HsF = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123653);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new hc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((hc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdee.HsG = ((hc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123653);
        return 0;
      }
      AppMethodBeat.o(123653);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dee
 * JD-Core Version:    0.7.0.1
 */