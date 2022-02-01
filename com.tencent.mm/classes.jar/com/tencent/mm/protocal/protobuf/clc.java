package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clc
  extends com.tencent.mm.cd.a
{
  public String ROQ;
  public aim TsF;
  public String TsG;
  public float height;
  public String url;
  public float width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91522);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.f(1, this.url);
      }
      if (this.ROQ != null) {
        paramVarArgs.f(2, this.ROQ);
      }
      paramVarArgs.i(3, this.width);
      paramVarArgs.i(4, this.height);
      if (this.TsF != null)
      {
        paramVarArgs.oE(6, this.TsF.computeSize());
        this.TsF.writeFields(paramVarArgs);
      }
      if (this.TsG != null) {
        paramVarArgs.f(7, this.TsG);
      }
      AppMethodBeat.o(91522);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label566;
      }
    }
    label566:
    for (paramInt = g.a.a.b.b.a.g(1, this.url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ROQ != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.ROQ);
      }
      i = i + (g.a.a.b.b.a.gL(3) + 4) + (g.a.a.b.b.a.gL(4) + 4);
      paramInt = i;
      if (this.TsF != null) {
        paramInt = i + g.a.a.a.oD(6, this.TsF.computeSize());
      }
      i = paramInt;
      if (this.TsG != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TsG);
      }
      AppMethodBeat.o(91522);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91522);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        clc localclc = (clc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(91522);
          return -1;
        case 1: 
          localclc.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91522);
          return 0;
        case 2: 
          localclc.ROQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91522);
          return 0;
        case 3: 
          localclc.width = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(91522);
          return 0;
        case 4: 
          localclc.height = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(91522);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aim localaim = new aim();
            if ((localObject != null) && (localObject.length > 0)) {
              localaim.parseFrom((byte[])localObject);
            }
            localclc.TsF = localaim;
            paramInt += 1;
          }
          AppMethodBeat.o(91522);
          return 0;
        }
        localclc.TsG = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91522);
        return 0;
      }
      AppMethodBeat.o(91522);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clc
 * JD-Core Version:    0.7.0.1
 */