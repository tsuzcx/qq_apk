package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddq
  extends com.tencent.mm.cd.a
{
  public LinkedList<Double> GTN;
  public dmx TLh;
  public double TLi;
  public String text;
  
  public ddq()
  {
    AppMethodBeat.i(118410);
    this.GTN = new LinkedList();
    AppMethodBeat.o(118410);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118411);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.text != null) {
        paramVarArgs.f(1, this.text);
      }
      if (this.TLh != null)
      {
        paramVarArgs.oE(2, this.TLh.computeSize());
        this.TLh.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, this.TLi);
      paramVarArgs.e(4, 4, this.GTN);
      AppMethodBeat.o(118411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label461;
      }
    }
    label461:
    for (paramInt = g.a.a.b.b.a.g(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.TLh != null) {
        i = paramInt + g.a.a.a.oD(2, this.TLh.computeSize());
      }
      paramInt = g.a.a.b.b.a.gL(3);
      int j = g.a.a.a.c(4, 4, this.GTN);
      AppMethodBeat.o(118411);
      return i + (paramInt + 8) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GTN.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(118411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ddq localddq = (ddq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118411);
          return -1;
        case 1: 
          localddq.text = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(118411);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dmx localdmx = new dmx();
            if ((localObject != null) && (localObject.length > 0)) {
              localdmx.parseFrom((byte[])localObject);
            }
            localddq.TLh = localdmx;
            paramInt += 1;
          }
          AppMethodBeat.o(118411);
          return 0;
        case 3: 
          localddq.TLi = Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP());
          AppMethodBeat.o(118411);
          return 0;
        }
        localddq.GTN.add(Double.valueOf(Double.longBitsToDouble(((g.a.a.a.a)localObject).abFh.AP())));
        AppMethodBeat.o(118411);
        return 0;
      }
      AppMethodBeat.o(118411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddq
 * JD-Core Version:    0.7.0.1
 */