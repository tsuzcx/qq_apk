package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpb
  extends dyl
{
  public String TWd;
  public String TWe;
  public String TWf;
  public String TWg;
  public String TWh;
  public int TWi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32374);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TWd != null) {
        paramVarArgs.f(2, this.TWd);
      }
      if (this.TWe != null) {
        paramVarArgs.f(3, this.TWe);
      }
      if (this.TWf != null) {
        paramVarArgs.f(4, this.TWf);
      }
      if (this.TWg != null) {
        paramVarArgs.f(5, this.TWg);
      }
      if (this.TWh != null) {
        paramVarArgs.f(6, this.TWh);
      }
      paramVarArgs.aY(7, this.TWi);
      AppMethodBeat.o(32374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label649;
      }
    }
    label649:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TWd != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TWd);
      }
      i = paramInt;
      if (this.TWe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TWe);
      }
      paramInt = i;
      if (this.TWf != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.TWf);
      }
      i = paramInt;
      if (this.TWg != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.TWg);
      }
      paramInt = i;
      if (this.TWh != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TWh);
      }
      i = g.a.a.b.b.a.bM(7, this.TWi);
      AppMethodBeat.o(32374);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dpb localdpb = (dpb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32374);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdpb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32374);
          return 0;
        case 2: 
          localdpb.TWd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 3: 
          localdpb.TWe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 4: 
          localdpb.TWf = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 5: 
          localdpb.TWg = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32374);
          return 0;
        case 6: 
          localdpb.TWh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32374);
          return 0;
        }
        localdpb.TWi = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(32374);
        return 0;
      }
      AppMethodBeat.o(32374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpb
 * JD-Core Version:    0.7.0.1
 */