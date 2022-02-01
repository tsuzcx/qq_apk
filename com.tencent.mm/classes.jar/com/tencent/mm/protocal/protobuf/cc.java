package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cc
  extends ckq
{
  public b CwY;
  public int CwZ;
  public String dlB;
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
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nickname != null) {
        paramVarArgs.d(2, this.nickname);
      }
      if (this.CwY != null) {
        paramVarArgs.c(3, this.CwY);
      }
      if (this.fileid != null) {
        paramVarArgs.d(4, this.fileid);
      }
      paramVarArgs.aR(5, this.CwZ);
      if (this.dlB != null) {
        paramVarArgs.d(6, this.dlB);
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
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.nickname);
      }
      i = paramInt;
      if (this.CwY != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.CwY);
      }
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.fileid);
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.CwZ);
      paramInt = i;
      if (this.dlB != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dlB);
      }
      AppMethodBeat.o(152481);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152481);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cc localcc = (cc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152481);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcc.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152481);
          return 0;
        case 2: 
          localcc.nickname = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 3: 
          localcc.CwY = ((f.a.a.a.a)localObject1).KhF.fMu();
          AppMethodBeat.o(152481);
          return 0;
        case 4: 
          localcc.fileid = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152481);
          return 0;
        case 5: 
          localcc.CwZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152481);
          return 0;
        }
        localcc.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(152481);
        return 0;
      }
      AppMethodBeat.o(152481);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cc
 * JD-Core Version:    0.7.0.1
 */