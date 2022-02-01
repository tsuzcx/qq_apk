package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class azx
  extends esc
{
  public int BeA;
  public b ZEQ;
  public bku ZKN;
  public LinkedList<FinderObject> object;
  public int wrl;
  
  public azx()
  {
    AppMethodBeat.i(258961);
    this.object = new LinkedList();
    AppMethodBeat.o(258961);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258968);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.object);
      if (this.ZEQ != null) {
        paramVarArgs.d(3, this.ZEQ);
      }
      paramVarArgs.bS(4, this.BeA);
      if (this.ZKN != null)
      {
        paramVarArgs.qD(5, this.ZKN.computeSize());
        this.ZKN.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.wrl);
      AppMethodBeat.o(258968);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label688;
      }
    }
    label688:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.object);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.ZEQ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.BeA);
      paramInt = i;
      if (this.ZKN != null) {
        paramInt = i + i.a.a.a.qC(5, this.ZKN.computeSize());
      }
      i = i.a.a.b.b.a.cJ(6, this.wrl);
      AppMethodBeat.o(258968);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.object.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258968);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        azx localazx = (azx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258968);
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
            localazx.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258968);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localazx.object.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258968);
          return 0;
        case 3: 
          localazx.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258968);
          return 0;
        case 4: 
          localazx.BeA = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258968);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bku();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bku)localObject2).parseFrom((byte[])localObject1);
            }
            localazx.ZKN = ((bku)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258968);
          return 0;
        }
        localazx.wrl = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258968);
        return 0;
      }
      AppMethodBeat.o(258968);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azx
 * JD-Core Version:    0.7.0.1
 */