package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbo
  extends com.tencent.mm.bx.a
{
  public String ZUh;
  public String aakO;
  public int aakP;
  public int aakQ;
  public int aakR;
  public int aakS;
  public int aakT;
  public String aakU;
  public LinkedList<String> aakV;
  public cbt aakW;
  public int aakX;
  public String icon_url;
  
  public cbo()
  {
    AppMethodBeat.i(258161);
    this.aakV = new LinkedList();
    AppMethodBeat.o(258161);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258171);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aakO != null) {
        paramVarArgs.g(1, this.aakO);
      }
      if (this.ZUh != null) {
        paramVarArgs.g(2, this.ZUh);
      }
      paramVarArgs.bS(3, this.aakP);
      paramVarArgs.bS(4, this.aakQ);
      paramVarArgs.bS(5, this.aakR);
      paramVarArgs.bS(6, this.aakS);
      paramVarArgs.bS(7, this.aakT);
      if (this.icon_url != null) {
        paramVarArgs.g(8, this.icon_url);
      }
      if (this.aakU != null) {
        paramVarArgs.g(9, this.aakU);
      }
      paramVarArgs.e(10, 1, this.aakV);
      if (this.aakW != null)
      {
        paramVarArgs.qD(11, this.aakW.computeSize());
        this.aakW.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.aakX);
      AppMethodBeat.o(258171);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aakO == null) {
        break label856;
      }
    }
    label856:
    for (paramInt = i.a.a.b.b.a.h(1, this.aakO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZUh != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.ZUh);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.aakP) + i.a.a.b.b.a.cJ(4, this.aakQ) + i.a.a.b.b.a.cJ(5, this.aakR) + i.a.a.b.b.a.cJ(6, this.aakS) + i.a.a.b.b.a.cJ(7, this.aakT);
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.icon_url);
      }
      i = paramInt;
      if (this.aakU != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.aakU);
      }
      i += i.a.a.a.c(10, 1, this.aakV);
      paramInt = i;
      if (this.aakW != null) {
        paramInt = i + i.a.a.a.qC(11, this.aakW.computeSize());
      }
      i = i.a.a.b.b.a.cJ(12, this.aakX);
      AppMethodBeat.o(258171);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aakV.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258171);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cbo localcbo = (cbo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258171);
          return -1;
        case 1: 
          localcbo.aakO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258171);
          return 0;
        case 2: 
          localcbo.ZUh = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258171);
          return 0;
        case 3: 
          localcbo.aakP = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258171);
          return 0;
        case 4: 
          localcbo.aakQ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258171);
          return 0;
        case 5: 
          localcbo.aakR = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258171);
          return 0;
        case 6: 
          localcbo.aakS = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258171);
          return 0;
        case 7: 
          localcbo.aakT = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258171);
          return 0;
        case 8: 
          localcbo.icon_url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258171);
          return 0;
        case 9: 
          localcbo.aakU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258171);
          return 0;
        case 10: 
          localcbo.aakV.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(258171);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            cbt localcbt = new cbt();
            if ((localObject != null) && (localObject.length > 0)) {
              localcbt.parseFrom((byte[])localObject);
            }
            localcbo.aakW = localcbt;
            paramInt += 1;
          }
          AppMethodBeat.o(258171);
          return 0;
        }
        localcbo.aakX = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258171);
        return 0;
      }
      AppMethodBeat.o(258171);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbo
 * JD-Core Version:    0.7.0.1
 */