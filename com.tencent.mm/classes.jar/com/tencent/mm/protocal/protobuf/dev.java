package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dev
  extends com.tencent.mm.bx.a
{
  public String YSb;
  public int aaKR;
  public LinkedList<czo> aaKS;
  public int method;
  public String url;
  
  public dev()
  {
    AppMethodBeat.i(258576);
    this.aaKS = new LinkedList();
    AppMethodBeat.o(258576);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258582);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      if (this.YSb != null) {
        paramVarArgs.g(2, this.YSb);
      }
      paramVarArgs.bS(3, this.aaKR);
      paramVarArgs.e(4, 8, this.aaKS);
      paramVarArgs.bS(5, this.method);
      AppMethodBeat.o(258582);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label484;
      }
    }
    label484:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YSb != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YSb);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.aaKR);
      int j = i.a.a.a.c(4, 8, this.aaKS);
      int k = i.a.a.b.b.a.cJ(5, this.method);
      AppMethodBeat.o(258582);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaKS.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258582);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dev localdev = (dev)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258582);
          return -1;
        case 1: 
          localdev.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258582);
          return 0;
        case 2: 
          localdev.YSb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258582);
          return 0;
        case 3: 
          localdev.aaKR = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258582);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            czo localczo = new czo();
            if ((localObject != null) && (localObject.length > 0)) {
              localczo.parseFrom((byte[])localObject);
            }
            localdev.aaKS.add(localczo);
            paramInt += 1;
          }
          AppMethodBeat.o(258582);
          return 0;
        }
        localdev.method = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258582);
        return 0;
      }
      AppMethodBeat.o(258582);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dev
 * JD-Core Version:    0.7.0.1
 */