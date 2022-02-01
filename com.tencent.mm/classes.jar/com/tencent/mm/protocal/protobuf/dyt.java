package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dyt
  extends cvw
{
  public int GqB;
  public long Hzw;
  public int Hzx;
  public String IdW;
  public com.tencent.mm.bw.b IdX;
  public com.tencent.mm.bw.b IdY;
  public String IdZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125498);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.IdW == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: ToBizUserName");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.IdY == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hzx);
      if (this.IdW != null) {
        paramVarArgs.d(3, this.IdW);
      }
      paramVarArgs.aS(4, this.GqB);
      if (this.IdX != null) {
        paramVarArgs.c(5, this.IdX);
      }
      if (this.IdY != null) {
        paramVarArgs.c(6, this.IdY);
      }
      paramVarArgs.aZ(7, this.Hzw);
      if (this.IdZ != null) {
        paramVarArgs.d(8, this.IdZ);
      }
      AppMethodBeat.o(125498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hzx);
      paramInt = i;
      if (this.IdW != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.IdW);
      }
      i = paramInt + f.a.a.b.b.a.bz(4, this.GqB);
      paramInt = i;
      if (this.IdX != null) {
        paramInt = i + f.a.a.b.b.a.b(5, this.IdX);
      }
      i = paramInt;
      if (this.IdY != null) {
        i = paramInt + f.a.a.b.b.a.b(6, this.IdY);
      }
      i += f.a.a.b.b.a.p(7, this.Hzw);
      paramInt = i;
      if (this.IdZ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.IdZ);
      }
      AppMethodBeat.o(125498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.IdW == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: ToBizUserName");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        if (this.IdY == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125498);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dyt localdyt = (dyt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125498);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdyt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125498);
          return 0;
        case 2: 
          localdyt.Hzx = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125498);
          return 0;
        case 3: 
          localdyt.IdW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125498);
          return 0;
        case 4: 
          localdyt.GqB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(125498);
          return 0;
        case 5: 
          localdyt.IdX = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(125498);
          return 0;
        case 6: 
          localdyt.IdY = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(125498);
          return 0;
        case 7: 
          localdyt.Hzw = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(125498);
          return 0;
        }
        localdyt.IdZ = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125498);
        return 0;
      }
      AppMethodBeat.o(125498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dyt
 * JD-Core Version:    0.7.0.1
 */