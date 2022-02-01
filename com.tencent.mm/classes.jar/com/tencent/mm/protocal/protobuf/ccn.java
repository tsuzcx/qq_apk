package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccn
  extends dyy
{
  public ebk TkA;
  public ebj TkB;
  public ecs TkC;
  public ect TkD;
  public ebv TkE;
  public ebw TkF;
  public ebs TkG;
  public ecn Tkz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211492);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Tkz != null)
      {
        paramVarArgs.oE(2, this.Tkz.computeSize());
        this.Tkz.writeFields(paramVarArgs);
      }
      if (this.TkA != null)
      {
        paramVarArgs.oE(3, this.TkA.computeSize());
        this.TkA.writeFields(paramVarArgs);
      }
      if (this.TkB != null)
      {
        paramVarArgs.oE(4, this.TkB.computeSize());
        this.TkB.writeFields(paramVarArgs);
      }
      if (this.TkC != null)
      {
        paramVarArgs.oE(5, this.TkC.computeSize());
        this.TkC.writeFields(paramVarArgs);
      }
      if (this.TkD != null)
      {
        paramVarArgs.oE(6, this.TkD.computeSize());
        this.TkD.writeFields(paramVarArgs);
      }
      if (this.TkE != null)
      {
        paramVarArgs.oE(7, this.TkE.computeSize());
        this.TkE.writeFields(paramVarArgs);
      }
      if (this.TkF != null)
      {
        paramVarArgs.oE(8, this.TkF.computeSize());
        this.TkF.writeFields(paramVarArgs);
      }
      if (this.TkG != null)
      {
        paramVarArgs.oE(9, this.TkG.computeSize());
        this.TkG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(211492);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1352;
      }
    }
    label1352:
    for (int i = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Tkz != null) {
        paramInt = i + g.a.a.a.oD(2, this.Tkz.computeSize());
      }
      i = paramInt;
      if (this.TkA != null) {
        i = paramInt + g.a.a.a.oD(3, this.TkA.computeSize());
      }
      paramInt = i;
      if (this.TkB != null) {
        paramInt = i + g.a.a.a.oD(4, this.TkB.computeSize());
      }
      i = paramInt;
      if (this.TkC != null) {
        i = paramInt + g.a.a.a.oD(5, this.TkC.computeSize());
      }
      paramInt = i;
      if (this.TkD != null) {
        paramInt = i + g.a.a.a.oD(6, this.TkD.computeSize());
      }
      i = paramInt;
      if (this.TkE != null) {
        i = paramInt + g.a.a.a.oD(7, this.TkE.computeSize());
      }
      paramInt = i;
      if (this.TkF != null) {
        paramInt = i + g.a.a.a.oD(8, this.TkF.computeSize());
      }
      i = paramInt;
      if (this.TkG != null) {
        i = paramInt + g.a.a.a.oD(9, this.TkG.computeSize());
      }
      AppMethodBeat.o(211492);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(211492);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ccn localccn = (ccn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(211492);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jh)localObject2).parseFrom((byte[])localObject1);
            }
            localccn.BaseResponse = ((jh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(211492);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ecn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ecn)localObject2).parseFrom((byte[])localObject1);
            }
            localccn.Tkz = ((ecn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(211492);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebk)localObject2).parseFrom((byte[])localObject1);
            }
            localccn.TkA = ((ebk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(211492);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebj)localObject2).parseFrom((byte[])localObject1);
            }
            localccn.TkB = ((ebj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(211492);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ecs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ecs)localObject2).parseFrom((byte[])localObject1);
            }
            localccn.TkC = ((ecs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(211492);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ect();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ect)localObject2).parseFrom((byte[])localObject1);
            }
            localccn.TkD = ((ect)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(211492);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebv)localObject2).parseFrom((byte[])localObject1);
            }
            localccn.TkE = ((ebv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(211492);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ebw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ebw)localObject2).parseFrom((byte[])localObject1);
            }
            localccn.TkF = ((ebw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(211492);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ebs();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ebs)localObject2).parseFrom((byte[])localObject1);
          }
          localccn.TkG = ((ebs)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(211492);
        return 0;
      }
      AppMethodBeat.o(211492);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccn
 * JD-Core Version:    0.7.0.1
 */