package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ce
  extends cvc
{
  public b FuE;
  public int FuF;
  public String duW;
  public String fileid;
  public String nickname;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152481);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.FuE != null) {
        paramVarArgs.c(3, this.FuE);
      }
      if (this.fileid != null) {
        paramVarArgs.d(4, this.fileid);
      }
      paramVarArgs.aS(5, this.FuF);
      if (this.duW != null) {
        paramVarArgs.d(6, this.duW);
      }
      AppMethodBeat.o(152481);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.FuE != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.FuE);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fileid);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.FuF);
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.duW);
      }
      AppMethodBeat.o(152481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ce localce = (ce)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152481);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localce.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152481);
          return 0;
        case 2: 
          localce.nickname = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 3: 
          localce.FuE = ((f.a.a.a.a)localObject1).NPN.gxI();
          AppMethodBeat.o(152481);
          return 0;
        case 4: 
          localce.fileid = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 5: 
          localce.FuF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152481);
          return 0;
        }
        localce.duW = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(152481);
        return 0;
      }
      AppMethodBeat.o(152481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ce
 * JD-Core Version:    0.7.0.1
 */