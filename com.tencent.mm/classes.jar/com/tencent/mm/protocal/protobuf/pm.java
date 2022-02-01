package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class pm
  extends erp
{
  public LinkedList<String> YSU;
  public b YSV;
  public int YSW;
  public int scene;
  
  public pm()
  {
    AppMethodBeat.i(258334);
    this.YSU = new LinkedList();
    AppMethodBeat.o(258334);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258341);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.YSU);
      if (this.YSV != null) {
        paramVarArgs.d(3, this.YSV);
      }
      paramVarArgs.bS(4, this.YSW);
      paramVarArgs.bS(5, this.scene);
      AppMethodBeat.o(258341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 1, this.YSU);
      paramInt = i;
      if (this.YSV != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.YSV);
      }
      i = i.a.a.b.b.a.cJ(4, this.YSW);
      int j = i.a.a.b.b.a.cJ(5, this.scene);
      AppMethodBeat.o(258341);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YSU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        pm localpm = (pm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258341);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localpm.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258341);
          return 0;
        case 2: 
          localpm.YSU.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(258341);
          return 0;
        case 3: 
          localpm.YSV = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(258341);
          return 0;
        case 4: 
          localpm.YSW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258341);
          return 0;
        }
        localpm.scene = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258341);
        return 0;
      }
      AppMethodBeat.o(258341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pm
 * JD-Core Version:    0.7.0.1
 */