package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class byd
  extends esc
{
  public b ZEQ;
  public LinkedList<FinderCommentInfo> aagX;
  public int aagY;
  public int aagZ;
  public int aaha;
  
  public byd()
  {
    AppMethodBeat.i(257968);
    this.aagX = new LinkedList();
    AppMethodBeat.o(257968);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257975);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.aagX);
      paramVarArgs.bS(3, this.aagY);
      paramVarArgs.bS(4, this.aagZ);
      paramVarArgs.bS(5, this.aaha);
      if (this.ZEQ != null) {
        paramVarArgs.d(100, this.ZEQ);
      }
      AppMethodBeat.o(257975);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label614;
      }
    }
    label614:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aagX) + i.a.a.b.b.a.cJ(3, this.aagY) + i.a.a.b.b.a.cJ(4, this.aagZ) + i.a.a.b.b.a.cJ(5, this.aaha);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(100, this.ZEQ);
      }
      AppMethodBeat.o(257975);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aagX.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257975);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        byd localbyd = (byd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257975);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localbyd.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257975);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderCommentInfo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderCommentInfo)localObject2).parseFrom((byte[])localObject1);
            }
            localbyd.aagX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257975);
          return 0;
        case 3: 
          localbyd.aagY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257975);
          return 0;
        case 4: 
          localbyd.aagZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257975);
          return 0;
        case 5: 
          localbyd.aaha = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257975);
          return 0;
        }
        localbyd.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(257975);
        return 0;
      }
      AppMethodBeat.o(257975);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byd
 * JD-Core Version:    0.7.0.1
 */