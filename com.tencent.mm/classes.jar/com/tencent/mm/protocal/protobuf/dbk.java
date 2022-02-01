package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbk
  extends com.tencent.mm.bx.a
{
  public String YMe;
  public alg aaGQ;
  public String aaGR;
  public float height;
  public String url;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91522);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.g(1, this.url);
      }
      if (this.YMe != null) {
        paramVarArgs.g(2, this.YMe);
      }
      paramVarArgs.l(3, this.width);
      paramVarArgs.l(4, this.height);
      if (this.aaGQ != null)
      {
        paramVarArgs.qD(6, this.aaGQ.computeSize());
        this.aaGQ.writeFields(paramVarArgs);
      }
      if (this.aaGR != null) {
        paramVarArgs.g(7, this.aaGR);
      }
      AppMethodBeat.o(91522);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = i.a.a.b.b.a.h(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YMe != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YMe);
      }
      i = i + (i.a.a.b.b.a.ko(3) + 4) + (i.a.a.b.b.a.ko(4) + 4);
      paramInt = i;
      if (this.aaGQ != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaGQ.computeSize());
      }
      i = paramInt;
      if (this.aaGR != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aaGR);
      }
      AppMethodBeat.o(91522);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91522);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dbk localdbk = (dbk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(91522);
          return -1;
        case 1: 
          localdbk.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91522);
          return 0;
        case 2: 
          localdbk.YMe = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91522);
          return 0;
        case 3: 
          localdbk.width = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(91522);
          return 0;
        case 4: 
          localdbk.height = Float.intBitsToFloat(((i.a.a.a.a)localObject).ajGk.aax());
          AppMethodBeat.o(91522);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            alg localalg = new alg();
            if ((localObject != null) && (localObject.length > 0)) {
              localalg.parseFrom((byte[])localObject);
            }
            localdbk.aaGQ = localalg;
            paramInt += 1;
          }
          AppMethodBeat.o(91522);
          return 0;
        }
        localdbk.aaGR = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91522);
        return 0;
      }
      AppMethodBeat.o(91522);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbk
 * JD-Core Version:    0.7.0.1
 */