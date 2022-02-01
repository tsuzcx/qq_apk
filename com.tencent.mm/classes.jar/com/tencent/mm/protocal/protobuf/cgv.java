package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgv
  extends cvp
{
  public String Hak;
  public cgy Hao;
  public LinkedList<cgv> Hap;
  public int Haq;
  public String type;
  public String wDT;
  
  public cgv()
  {
    AppMethodBeat.i(117539);
    this.Hap = new LinkedList();
    AppMethodBeat.o(117539);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117540);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Hao != null)
      {
        paramVarArgs.lC(2, this.Hao.computeSize());
        this.Hao.writeFields(paramVarArgs);
      }
      if (this.Hak != null) {
        paramVarArgs.d(3, this.Hak);
      }
      if (this.wDT != null) {
        paramVarArgs.d(4, this.wDT);
      }
      if (this.type != null) {
        paramVarArgs.d(5, this.type);
      }
      paramVarArgs.e(6, 8, this.Hap);
      paramVarArgs.aS(7, this.Haq);
      AppMethodBeat.o(117540);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label834;
      }
    }
    label834:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Hao != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hao.computeSize());
      }
      i = paramInt;
      if (this.Hak != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.Hak);
      }
      paramInt = i;
      if (this.wDT != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wDT);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.type);
      }
      paramInt = f.a.a.a.c(6, 8, this.Hap);
      int j = f.a.a.b.b.a.bz(7, this.Haq);
      AppMethodBeat.o(117540);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hap.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(117540);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgv localcgv = (cgv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117540);
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
            localcgv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgv.Hao = ((cgy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        case 3: 
          localcgv.Hak = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 4: 
          localcgv.wDT = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 5: 
          localcgv.type = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(117540);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgv.Hap.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117540);
          return 0;
        }
        localcgv.Haq = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117540);
        return 0;
      }
      AppMethodBeat.o(117540);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgv
 * JD-Core Version:    0.7.0.1
 */