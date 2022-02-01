package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class btf
  extends cld
{
  public float DQo;
  public String DQp;
  public String DQq;
  public LinkedList<deu> Duu;
  public com.tencent.mm.bx.b Dvq;
  public int hno;
  
  public btf()
  {
    AppMethodBeat.i(120958);
    this.Duu = new LinkedList();
    AppMethodBeat.o(120958);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(120959);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(120959);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.hno);
      paramVarArgs.e(3, 8, this.Duu);
      if (this.Dvq != null) {
        paramVarArgs.c(4, this.Dvq);
      }
      paramVarArgs.x(5, this.DQo);
      if (this.DQp != null) {
        paramVarArgs.d(6, this.DQp);
      }
      if (this.DQq != null) {
        paramVarArgs.d(7, this.DQq);
      }
      AppMethodBeat.o(120959);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label769;
      }
    }
    label769:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.hno) + f.a.a.a.c(3, 8, this.Duu);
      paramInt = i;
      if (this.Dvq != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.Dvq);
      }
      i = paramInt + (f.a.a.b.b.a.fY(5) + 4);
      paramInt = i;
      if (this.DQp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DQp);
      }
      i = paramInt;
      if (this.DQq != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DQq);
      }
      AppMethodBeat.o(120959);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Duu.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(120959);
          throw paramVarArgs;
        }
        AppMethodBeat.o(120959);
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
          AppMethodBeat.o(120959);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 2: 
          localbtf.hno = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(120959);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new deu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((deu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbtf.Duu.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(120959);
          return 0;
        case 4: 
          localbtf.Dvq = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(120959);
          return 0;
        case 5: 
          localbtf.DQo = Float.intBitsToFloat(((f.a.a.a.a)localObject1).KhF.fHx());
          AppMethodBeat.o(120959);
          return 0;
        case 6: 
          localbtf.DQp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(120959);
          return 0;
        }
        localbtf.DQq = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(120959);
        return 0;
      }
      AppMethodBeat.o(120959);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btf
 * JD-Core Version:    0.7.0.1
 */