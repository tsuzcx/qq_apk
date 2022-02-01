package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class czn
  extends com.tencent.mm.bw.a
{
  public String GnN;
  public String GnO;
  public cxn GuF;
  public acp HJi;
  public cxn Hed;
  public int Hhu;
  public String Hhv;
  public String Hhw;
  public String Hhx;
  public int Hhy;
  public int jfV;
  public String jfW;
  public String jfX;
  public String jfY;
  public int jfZ;
  public String jga;
  public String jge;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117918);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GuF == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117918);
        throw paramVarArgs;
      }
      if (this.Hed == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117918);
        throw paramVarArgs;
      }
      if (this.GuF != null)
      {
        paramVarArgs.lJ(1, this.GuF.computeSize());
        this.GuF.writeFields(paramVarArgs);
      }
      if (this.Hed != null)
      {
        paramVarArgs.lJ(2, this.Hed.computeSize());
        this.Hed.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.jfV);
      if (this.jfW != null) {
        paramVarArgs.d(4, this.jfW);
      }
      if (this.jfX != null) {
        paramVarArgs.d(5, this.jfX);
      }
      if (this.jfY != null) {
        paramVarArgs.d(6, this.jfY);
      }
      paramVarArgs.aS(7, this.jfZ);
      paramVarArgs.aS(8, this.Hhu);
      if (this.Hhv != null) {
        paramVarArgs.d(9, this.Hhv);
      }
      if (this.Hhw != null) {
        paramVarArgs.d(10, this.Hhw);
      }
      if (this.jga != null) {
        paramVarArgs.d(11, this.jga);
      }
      if (this.Hhx != null) {
        paramVarArgs.d(12, this.Hhx);
      }
      paramVarArgs.aS(13, this.Hhy);
      if (this.jge != null) {
        paramVarArgs.d(14, this.jge);
      }
      if (this.HJi != null)
      {
        paramVarArgs.lJ(15, this.HJi.computeSize());
        this.HJi.writeFields(paramVarArgs);
      }
      if (this.GnN != null) {
        paramVarArgs.d(16, this.GnN);
      }
      if (this.GnO != null) {
        paramVarArgs.d(17, this.GnO);
      }
      AppMethodBeat.o(117918);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GuF == null) {
        break label1514;
      }
    }
    label1514:
    for (paramInt = f.a.a.a.lI(1, this.GuF.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Hed != null) {
        i = paramInt + f.a.a.a.lI(2, this.Hed.computeSize());
      }
      i += f.a.a.b.b.a.bz(3, this.jfV);
      paramInt = i;
      if (this.jfW != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.jfW);
      }
      i = paramInt;
      if (this.jfX != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.jfX);
      }
      paramInt = i;
      if (this.jfY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.jfY);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.jfZ) + f.a.a.b.b.a.bz(8, this.Hhu);
      paramInt = i;
      if (this.Hhv != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hhv);
      }
      i = paramInt;
      if (this.Hhw != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Hhw);
      }
      paramInt = i;
      if (this.jga != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.jga);
      }
      i = paramInt;
      if (this.Hhx != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Hhx);
      }
      i += f.a.a.b.b.a.bz(13, this.Hhy);
      paramInt = i;
      if (this.jge != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.jge);
      }
      i = paramInt;
      if (this.HJi != null) {
        i = paramInt + f.a.a.a.lI(15, this.HJi.computeSize());
      }
      paramInt = i;
      if (this.GnN != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.GnN);
      }
      i = paramInt;
      if (this.GnO != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.GnO);
      }
      AppMethodBeat.o(117918);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GuF == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(117918);
          throw paramVarArgs;
        }
        if (this.Hed == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117918);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117918);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czn localczn = (czn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117918);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczn.GuF = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczn.Hed = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 3: 
          localczn.jfV = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117918);
          return 0;
        case 4: 
          localczn.jfW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 5: 
          localczn.jfX = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 6: 
          localczn.jfY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 7: 
          localczn.jfZ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117918);
          return 0;
        case 8: 
          localczn.Hhu = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117918);
          return 0;
        case 9: 
          localczn.Hhv = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 10: 
          localczn.Hhw = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 11: 
          localczn.jga = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 12: 
          localczn.Hhx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 13: 
          localczn.Hhy = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(117918);
          return 0;
        case 14: 
          localczn.jge = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117918);
          return 0;
        case 15: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localczn.HJi = ((acp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117918);
          return 0;
        case 16: 
          localczn.GnN = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(117918);
          return 0;
        }
        localczn.GnO = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(117918);
        return 0;
      }
      AppMethodBeat.o(117918);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czn
 * JD-Core Version:    0.7.0.1
 */