package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cg
  extends ckq
{
  public LinkedList<bpm> Cxd;
  public cmf Cxe;
  public int Cxf;
  public String Cxg;
  public int fpb;
  
  public cg()
  {
    AppMethodBeat.i(101790);
    this.Cxd = new LinkedList();
    AppMethodBeat.o(101790);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101791);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Cxe == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101791);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.fpb);
      paramVarArgs.e(3, 8, this.Cxd);
      if (this.Cxe != null)
      {
        paramVarArgs.kX(4, this.Cxe.computeSize());
        this.Cxe.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.Cxf);
      if (this.Cxg != null) {
        paramVarArgs.d(6, this.Cxg);
      }
      AppMethodBeat.o(101791);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label802;
      }
    }
    label802:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.fpb) + f.a.a.a.c(3, 8, this.Cxd);
      paramInt = i;
      if (this.Cxe != null) {
        paramInt = i + f.a.a.a.kW(4, this.Cxe.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.Cxf);
      paramInt = i;
      if (this.Cxg != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Cxg);
      }
      AppMethodBeat.o(101791);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Cxd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Cxe == null)
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
        cg localcg = (cg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101791);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcg.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 2: 
          localcg.fpb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101791);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcg.Cxd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcg.Cxe = ((cmf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(101791);
          return 0;
        case 5: 
          localcg.Cxf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(101791);
          return 0;
        }
        localcg.Cxg = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(101791);
        return 0;
      }
      AppMethodBeat.o(101791);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cg
 * JD-Core Version:    0.7.0.1
 */