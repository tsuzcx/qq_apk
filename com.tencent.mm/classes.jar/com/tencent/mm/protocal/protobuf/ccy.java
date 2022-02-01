package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class ccy
  extends com.tencent.mm.bx.a
{
  public String aamn;
  public LinkedList<String> aamr;
  public LinkedList<ccz> aams;
  public int aamt;
  
  public ccy()
  {
    AppMethodBeat.i(257657);
    this.aamr = new LinkedList();
    this.aams = new LinkedList();
    AppMethodBeat.o(257657);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257661);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aamn != null) {
        paramVarArgs.g(1, this.aamn);
      }
      paramVarArgs.e(2, 1, this.aamr);
      paramVarArgs.e(3, 8, this.aams);
      paramVarArgs.bS(4, this.aamt);
      AppMethodBeat.o(257661);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aamn == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = i.a.a.b.b.a.h(1, this.aamn) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 1, this.aamr);
      int j = i.a.a.a.c(3, 8, this.aams);
      int k = i.a.a.b.b.a.cJ(4, this.aamt);
      AppMethodBeat.o(257661);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aamr.clear();
        this.aams.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257661);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ccy localccy = (ccy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257661);
          return -1;
        case 1: 
          localccy.aamn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257661);
          return 0;
        case 2: 
          localccy.aamr.add(((i.a.a.a.a)localObject).ajGk.readString());
          AppMethodBeat.o(257661);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ccz localccz = new ccz();
            if ((localObject != null) && (localObject.length > 0)) {
              localccz.parseFrom((byte[])localObject);
            }
            localccy.aams.add(localccz);
            paramInt += 1;
          }
          AppMethodBeat.o(257661);
          return 0;
        }
        localccy.aamt = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257661);
        return 0;
      }
      AppMethodBeat.o(257661);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccy
 * JD-Core Version:    0.7.0.1
 */