package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ue
  extends erp
{
  public uc YZQ;
  public LinkedList<Integer> YZj;
  public int scene;
  
  public ue()
  {
    AppMethodBeat.i(259174);
    this.YZj = new LinkedList();
    AppMethodBeat.o(259174);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259177);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.YZj);
      if (this.YZQ != null)
      {
        paramVarArgs.qD(3, this.YZQ.computeSize());
        this.YZQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.scene);
      AppMethodBeat.o(259177);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label525;
      }
    }
    label525:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 2, this.YZj);
      paramInt = i;
      if (this.YZQ != null) {
        paramInt = i + i.a.a.a.qC(3, this.YZQ.computeSize());
      }
      i = i.a.a.b.b.a.cJ(4, this.scene);
      AppMethodBeat.o(259177);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YZj.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259177);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ue localue = (ue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259177);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localue.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259177);
          return 0;
        case 2: 
          localue.YZj.add(Integer.valueOf(((i.a.a.a.a)localObject1).ajGk.aar()));
          AppMethodBeat.o(259177);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uc)localObject2).parseFrom((byte[])localObject1);
            }
            localue.YZQ = ((uc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259177);
          return 0;
        }
        localue.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259177);
        return 0;
      }
      AppMethodBeat.o(259177);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ue
 * JD-Core Version:    0.7.0.1
 */