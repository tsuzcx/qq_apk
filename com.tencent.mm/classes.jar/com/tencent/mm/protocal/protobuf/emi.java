package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emi
  extends com.tencent.mm.cd.a
{
  public emh UoT;
  public emh UoU;
  public emh UoV;
  public int UoW;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123655);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UoT != null)
      {
        paramVarArgs.oE(1, this.UoT.computeSize());
        this.UoT.writeFields(paramVarArgs);
      }
      if (this.UoU != null)
      {
        paramVarArgs.oE(2, this.UoU.computeSize());
        this.UoU.writeFields(paramVarArgs);
      }
      if (this.UoV != null)
      {
        paramVarArgs.oE(3, this.UoV.computeSize());
        this.UoV.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.scene);
      paramVarArgs.aY(5, this.UoW);
      AppMethodBeat.o(123655);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UoT == null) {
        break label644;
      }
    }
    label644:
    for (int i = g.a.a.a.oD(1, this.UoT.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UoU != null) {
        paramInt = i + g.a.a.a.oD(2, this.UoU.computeSize());
      }
      i = paramInt;
      if (this.UoV != null) {
        i = paramInt + g.a.a.a.oD(3, this.UoV.computeSize());
      }
      paramInt = g.a.a.b.b.a.bM(4, this.scene);
      int j = g.a.a.b.b.a.bM(5, this.UoW);
      AppMethodBeat.o(123655);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(123655);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        emi localemi = (emi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        emh localemh;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123655);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localemh = new emh();
            if ((localObject != null) && (localObject.length > 0)) {
              localemh.parseFrom((byte[])localObject);
            }
            localemi.UoT = localemh;
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localemh = new emh();
            if ((localObject != null) && (localObject.length > 0)) {
              localemh.parseFrom((byte[])localObject);
            }
            localemi.UoU = localemh;
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localemh = new emh();
            if ((localObject != null) && (localObject.length > 0)) {
              localemh.parseFrom((byte[])localObject);
            }
            localemi.UoV = localemh;
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 4: 
          localemi.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(123655);
          return 0;
        }
        localemi.UoW = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(123655);
        return 0;
      }
      AppMethodBeat.o(123655);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emi
 * JD-Core Version:    0.7.0.1
 */