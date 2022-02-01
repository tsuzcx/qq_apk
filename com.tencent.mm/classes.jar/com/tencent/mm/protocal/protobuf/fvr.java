package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class fvr
  extends com.tencent.mm.bx.a
{
  public fyd abTR;
  public int previewHeight;
  public int previewWidth;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110915);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abTR == null)
      {
        paramVarArgs = new b("Not all required fields were included: materialResp");
        AppMethodBeat.o(110915);
        throw paramVarArgs;
      }
      if (this.abTR != null)
      {
        paramVarArgs.qD(1, this.abTR.computeSize());
        this.abTR.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.previewWidth);
      paramVarArgs.bS(3, this.previewHeight);
      AppMethodBeat.o(110915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abTR == null) {
        break label424;
      }
    }
    label424:
    for (paramInt = i.a.a.a.qC(1, this.abTR.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.previewWidth);
      int j = i.a.a.b.b.a.cJ(3, this.previewHeight);
      AppMethodBeat.o(110915);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abTR == null)
        {
          paramVarArgs = new b("Not all required fields were included: materialResp");
          AppMethodBeat.o(110915);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fvr localfvr = (fvr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110915);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fyd localfyd = new fyd();
            if ((localObject != null) && (localObject.length > 0)) {
              localfyd.parseFrom((byte[])localObject);
            }
            localfvr.abTR = localfyd;
            paramInt += 1;
          }
          AppMethodBeat.o(110915);
          return 0;
        case 2: 
          localfvr.previewWidth = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(110915);
          return 0;
        }
        localfvr.previewHeight = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(110915);
        return 0;
      }
      AppMethodBeat.o(110915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvr
 * JD-Core Version:    0.7.0.1
 */