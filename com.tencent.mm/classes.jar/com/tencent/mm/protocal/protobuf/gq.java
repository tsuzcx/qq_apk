package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gq
  extends com.tencent.mm.cd.a
{
  public dfd RLD;
  public LinkedList<dfd> RLE;
  public String fAo;
  public String fHp;
  
  public gq()
  {
    AppMethodBeat.i(152496);
    this.RLE = new LinkedList();
    AppMethodBeat.o(152496);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152497);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fHp != null) {
        paramVarArgs.f(1, this.fHp);
      }
      if (this.RLD != null)
      {
        paramVarArgs.oE(2, this.RLD.computeSize());
        this.RLD.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.RLE);
      if (this.fAo != null) {
        paramVarArgs.f(4, this.fAo);
      }
      AppMethodBeat.o(152497);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fHp == null) {
        break label526;
      }
    }
    label526:
    for (paramInt = g.a.a.b.b.a.g(1, this.fHp) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.RLD != null) {
        i = paramInt + g.a.a.a.oD(2, this.RLD.computeSize());
      }
      i += g.a.a.a.c(3, 8, this.RLE);
      paramInt = i;
      if (this.fAo != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.fAo);
      }
      AppMethodBeat.o(152497);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.RLE.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(152497);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        gq localgq = (gq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        dfd localdfd;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152497);
          return -1;
        case 1: 
          localgq.fHp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(152497);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdfd = new dfd();
            if ((localObject != null) && (localObject.length > 0)) {
              localdfd.parseFrom((byte[])localObject);
            }
            localgq.RLD = localdfd;
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localdfd = new dfd();
            if ((localObject != null) && (localObject.length > 0)) {
              localdfd.parseFrom((byte[])localObject);
            }
            localgq.RLE.add(localdfd);
            paramInt += 1;
          }
          AppMethodBeat.o(152497);
          return 0;
        }
        localgq.fAo = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(152497);
        return 0;
      }
      AppMethodBeat.o(152497);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gq
 * JD-Core Version:    0.7.0.1
 */