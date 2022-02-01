package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public class bgd
  extends com.tencent.mm.cd.a
{
  public bio SRb;
  public LinkedList<bio> SRc;
  public b SRd;
  
  public bgd()
  {
    AppMethodBeat.i(199269);
    this.SRc = new LinkedList();
    AppMethodBeat.o(199269);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(199273);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.SRb != null)
      {
        paramVarArgs.oE(1, this.SRb.computeSize());
        this.SRb.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.SRc);
      if (this.SRd != null) {
        paramVarArgs.c(3, this.SRd);
      }
      AppMethodBeat.o(199273);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SRb == null) {
        break label466;
      }
    }
    label466:
    for (paramInt = g.a.a.a.oD(1, this.SRb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.SRc);
      paramInt = i;
      if (this.SRd != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.SRd);
      }
      AppMethodBeat.o(199273);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.SRc.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(199273);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bgd localbgd = (bgd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        bio localbio;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(199273);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbio = new bio();
            if ((localObject != null) && (localObject.length > 0)) {
              localbio.parseFrom((byte[])localObject);
            }
            localbgd.SRb = localbio;
            paramInt += 1;
          }
          AppMethodBeat.o(199273);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbio = new bio();
            if ((localObject != null) && (localObject.length > 0)) {
              localbio.parseFrom((byte[])localObject);
            }
            localbgd.SRc.add(localbio);
            paramInt += 1;
          }
          AppMethodBeat.o(199273);
          return 0;
        }
        localbgd.SRd = ((g.a.a.a.a)localObject).abFh.iUw();
        AppMethodBeat.o(199273);
        return 0;
      }
      AppMethodBeat.o(199273);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgd
 * JD-Core Version:    0.7.0.1
 */