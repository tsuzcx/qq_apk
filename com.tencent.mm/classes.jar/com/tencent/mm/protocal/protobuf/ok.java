package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class ok
  extends cwj
{
  public int FZk;
  public lz Gcb;
  public mx Gcc;
  public ob Gcd;
  public mz Gce;
  public ob Gcf;
  public pb Gcg;
  public LinkedList<aul> Gch;
  public int Gci;
  public cne Gcj;
  public String Gck;
  
  public ok()
  {
    AppMethodBeat.i(124444);
    this.Gch = new LinkedList();
    AppMethodBeat.o(124444);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124445);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124445);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Gcb != null)
      {
        paramVarArgs.lJ(2, this.Gcb.computeSize());
        this.Gcb.writeFields(paramVarArgs);
      }
      if (this.Gcc != null)
      {
        paramVarArgs.lJ(3, this.Gcc.computeSize());
        this.Gcc.writeFields(paramVarArgs);
      }
      if (this.Gcd != null)
      {
        paramVarArgs.lJ(4, this.Gcd.computeSize());
        this.Gcd.writeFields(paramVarArgs);
      }
      if (this.Gce != null)
      {
        paramVarArgs.lJ(5, this.Gce.computeSize());
        this.Gce.writeFields(paramVarArgs);
      }
      if (this.Gcf != null)
      {
        paramVarArgs.lJ(6, this.Gcf.computeSize());
        this.Gcf.writeFields(paramVarArgs);
      }
      if (this.Gcg != null)
      {
        paramVarArgs.lJ(7, this.Gcg.computeSize());
        this.Gcg.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(8, this.FZk);
      paramVarArgs.e(9, 8, this.Gch);
      paramVarArgs.aS(10, this.Gci);
      if (this.Gcj != null)
      {
        paramVarArgs.lJ(11, this.Gcj.computeSize());
        this.Gcj.writeFields(paramVarArgs);
      }
      if (this.Gck != null) {
        paramVarArgs.d(12, this.Gck);
      }
      AppMethodBeat.o(124445);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1734;
      }
    }
    label1734:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gcb != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gcb.computeSize());
      }
      i = paramInt;
      if (this.Gcc != null) {
        i = paramInt + f.a.a.a.lI(3, this.Gcc.computeSize());
      }
      paramInt = i;
      if (this.Gcd != null) {
        paramInt = i + f.a.a.a.lI(4, this.Gcd.computeSize());
      }
      i = paramInt;
      if (this.Gce != null) {
        i = paramInt + f.a.a.a.lI(5, this.Gce.computeSize());
      }
      paramInt = i;
      if (this.Gcf != null) {
        paramInt = i + f.a.a.a.lI(6, this.Gcf.computeSize());
      }
      i = paramInt;
      if (this.Gcg != null) {
        i = paramInt + f.a.a.a.lI(7, this.Gcg.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(8, this.FZk) + f.a.a.a.c(9, 8, this.Gch) + f.a.a.b.b.a.bz(10, this.Gci);
      paramInt = i;
      if (this.Gcj != null) {
        paramInt = i + f.a.a.a.lI(11, this.Gcj.computeSize());
      }
      i = paramInt;
      if (this.Gck != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Gck);
      }
      AppMethodBeat.o(124445);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gch.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(124445);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124445);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ok localok = (ok)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124445);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localok.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localok.Gcb = ((lz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localok.Gcc = ((mx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ob();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localok.Gcd = ((ob)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((mz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localok.Gce = ((mz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ob();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ob)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localok.Gcf = ((ob)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localok.Gcg = ((pb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 8: 
          localok.FZk = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124445);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aul();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aul)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localok.Gch.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        case 10: 
          localok.Gci = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(124445);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cne();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cne)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localok.Gcj = ((cne)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124445);
          return 0;
        }
        localok.Gck = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(124445);
        return 0;
      }
      AppMethodBeat.o(124445);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ok
 * JD-Core Version:    0.7.0.1
 */