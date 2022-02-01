package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import java.util.LinkedList;

public final class dkg
  extends dyl
{
  public int RML;
  public int Sdk;
  public bd Sdp;
  public String TRG;
  public String TRH;
  public b TRI;
  public int TRJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91598);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TRG != null) {
        paramVarArgs.f(2, this.TRG);
      }
      if (this.TRH != null) {
        paramVarArgs.f(3, this.TRH);
      }
      if (this.TRI != null) {
        paramVarArgs.c(4, this.TRI);
      }
      paramVarArgs.aY(5, this.Sdk);
      paramVarArgs.aY(6, this.RML);
      paramVarArgs.aY(7, this.TRJ);
      if (this.Sdp != null)
      {
        paramVarArgs.oE(8, this.Sdp.computeSize());
        this.Sdp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91598);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label734;
      }
    }
    label734:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TRG != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TRG);
      }
      i = paramInt;
      if (this.TRH != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.TRH);
      }
      paramInt = i;
      if (this.TRI != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.TRI);
      }
      i = paramInt + g.a.a.b.b.a.bM(5, this.Sdk) + g.a.a.b.b.a.bM(6, this.RML) + g.a.a.b.b.a.bM(7, this.TRJ);
      paramInt = i;
      if (this.Sdp != null) {
        paramInt = i + g.a.a.a.oD(8, this.Sdp.computeSize());
      }
      AppMethodBeat.o(91598);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dkg localdkg = (dkg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91598);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localdkg.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91598);
          return 0;
        case 2: 
          localdkg.TRG = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 3: 
          localdkg.TRH = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91598);
          return 0;
        case 4: 
          localdkg.TRI = ((g.a.a.a.a)localObject1).abFh.iUw();
          AppMethodBeat.o(91598);
          return 0;
        case 5: 
          localdkg.Sdk = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91598);
          return 0;
        case 6: 
          localdkg.RML = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91598);
          return 0;
        case 7: 
          localdkg.TRJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91598);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bd)localObject2).parseFrom((byte[])localObject1);
          }
          localdkg.Sdp = ((bd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(91598);
        return 0;
      }
      AppMethodBeat.o(91598);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkg
 * JD-Core Version:    0.7.0.1
 */