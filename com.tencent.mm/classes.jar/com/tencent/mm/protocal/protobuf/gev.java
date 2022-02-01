package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gev
  extends erp
{
  public int WoG;
  public double accp;
  public double accq;
  public String accr;
  public LinkedList<fvp> accs;
  public int scene;
  public String sessionId;
  
  public gev()
  {
    AppMethodBeat.i(121112);
    this.accs = new LinkedList();
    AppMethodBeat.o(121112);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(121113);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.d(2, this.accp);
      paramVarArgs.d(3, this.accq);
      if (this.accr != null) {
        paramVarArgs.g(4, this.accr);
      }
      paramVarArgs.bS(5, this.WoG);
      if (this.sessionId != null) {
        paramVarArgs.g(6, this.sessionId);
      }
      paramVarArgs.bS(7, this.scene);
      paramVarArgs.e(8, 8, this.accs);
      AppMethodBeat.o(121113);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label712;
      }
    }
    label712:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 8) + (i.a.a.b.b.a.ko(3) + 8);
      paramInt = i;
      if (this.accr != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.accr);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.WoG);
      paramInt = i;
      if (this.sessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.sessionId);
      }
      i = i.a.a.b.b.a.cJ(7, this.scene);
      int j = i.a.a.a.c(8, 8, this.accs);
      AppMethodBeat.o(121113);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.accs.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gev localgev = (gev)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(121113);
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
            localgev.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(121113);
          return 0;
        case 2: 
          localgev.accp = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(121113);
          return 0;
        case 3: 
          localgev.accq = Double.longBitsToDouble(((i.a.a.a.a)localObject1).ajGk.aay());
          AppMethodBeat.o(121113);
          return 0;
        case 4: 
          localgev.accr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 5: 
          localgev.WoG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(121113);
          return 0;
        case 6: 
          localgev.sessionId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(121113);
          return 0;
        case 7: 
          localgev.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(121113);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fvp();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fvp)localObject2).parseFrom((byte[])localObject1);
          }
          localgev.accs.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(121113);
        return 0;
      }
      AppMethodBeat.o(121113);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gev
 * JD-Core Version:    0.7.0.1
 */