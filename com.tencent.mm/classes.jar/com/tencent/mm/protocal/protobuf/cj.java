package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cj
  extends cvw
{
  public LinkedList<bzm> FNl;
  public cxn FNm;
  public int FNn;
  public String FNo;
  public boz FNp;
  public int fNf;
  
  public cj()
  {
    AppMethodBeat.i(101790);
    this.FNl = new LinkedList();
    AppMethodBeat.o(101790);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101791);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FNm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101791);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.fNf);
      paramVarArgs.e(3, 8, this.FNl);
      if (this.FNm != null)
      {
        paramVarArgs.lJ(4, this.FNm.computeSize());
        this.FNm.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.FNn);
      if (this.FNo != null) {
        paramVarArgs.d(6, this.FNo);
      }
      if (this.FNp != null)
      {
        paramVarArgs.lJ(7, this.FNp.computeSize());
        this.FNp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label958;
      }
    }
    label958:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.fNf) + f.a.a.a.c(3, 8, this.FNl);
      paramInt = i;
      if (this.FNm != null) {
        paramInt = i + f.a.a.a.lI(4, this.FNm.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FNn);
      paramInt = i;
      if (this.FNo != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FNo);
      }
      i = paramInt;
      if (this.FNp != null) {
        i = paramInt + f.a.a.a.lI(7, this.FNp.computeSize());
      }
      AppMethodBeat.o(101791);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FNl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FNm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101791);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101791);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cj localcj = (cj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101791);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 2: 
          localcj.fNf = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101791);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bzm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcj.FNl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cxn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcj.FNm = ((cxn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 5: 
          localcj.FNn = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(101791);
          return 0;
        case 6: 
          localcj.FNo = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(101791);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new boz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((boz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcj.FNp = ((boz)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(101791);
        return 0;
      }
      AppMethodBeat.o(101791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cj
 * JD-Core Version:    0.7.0.1
 */