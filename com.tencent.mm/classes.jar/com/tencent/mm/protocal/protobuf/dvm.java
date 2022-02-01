package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dvm
  extends com.tencent.mm.bx.a
{
  public LinkedList<Double> MRq;
  public efl abbg;
  public double abbh;
  public String text;
  
  public dvm()
  {
    AppMethodBeat.i(118410);
    this.MRq = new LinkedList();
    AppMethodBeat.o(118410);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118411);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.text != null) {
        paramVarArgs.g(1, this.text);
      }
      if (this.abbg != null)
      {
        paramVarArgs.qD(2, this.abbg.computeSize());
        this.abbg.writeFields(paramVarArgs);
      }
      paramVarArgs.d(3, this.abbh);
      paramVarArgs.e(4, 4, this.MRq);
      AppMethodBeat.o(118411);
      return 0;
    }
    if (paramInt == 1) {
      if (this.text == null) {
        break label457;
      }
    }
    label457:
    for (paramInt = i.a.a.b.b.a.h(1, this.text) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abbg != null) {
        i = paramInt + i.a.a.a.qC(2, this.abbg.computeSize());
      }
      paramInt = i.a.a.b.b.a.ko(3);
      int j = i.a.a.a.c(4, 4, this.MRq);
      AppMethodBeat.o(118411);
      return i + (paramInt + 8) + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MRq.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(118411);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dvm localdvm = (dvm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118411);
          return -1;
        case 1: 
          localdvm.text = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(118411);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            efl localefl = new efl();
            if ((localObject != null) && (localObject.length > 0)) {
              localefl.parseFrom((byte[])localObject);
            }
            localdvm.abbg = localefl;
            paramInt += 1;
          }
          AppMethodBeat.o(118411);
          return 0;
        case 3: 
          localdvm.abbh = Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay());
          AppMethodBeat.o(118411);
          return 0;
        }
        localdvm.MRq.add(Double.valueOf(Double.longBitsToDouble(((i.a.a.a.a)localObject).ajGk.aay())));
        AppMethodBeat.o(118411);
        return 0;
      }
      AppMethodBeat.o(118411);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dvm
 * JD-Core Version:    0.7.0.1
 */