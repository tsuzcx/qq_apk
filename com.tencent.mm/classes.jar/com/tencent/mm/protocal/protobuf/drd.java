package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class drd
  extends dyl
{
  public int DgI;
  public String Ine;
  public String OmF;
  public int Oms;
  public String TUW;
  public int TWH;
  public String TXA;
  public int TXB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91641);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.TXA != null) {
        paramVarArgs.f(2, this.TXA);
      }
      if (this.Ine != null) {
        paramVarArgs.f(3, this.Ine);
      }
      paramVarArgs.aY(4, this.TWH);
      paramVarArgs.aY(5, this.DgI);
      if (this.TUW != null) {
        paramVarArgs.f(6, this.TUW);
      }
      paramVarArgs.aY(7, this.Oms);
      paramVarArgs.aY(8, this.TXB);
      if (this.OmF != null) {
        paramVarArgs.f(100, this.OmF);
      }
      AppMethodBeat.o(91641);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label740;
      }
    }
    label740:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.TXA != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.TXA);
      }
      i = paramInt;
      if (this.Ine != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Ine);
      }
      i = i + g.a.a.b.b.a.bM(4, this.TWH) + g.a.a.b.b.a.bM(5, this.DgI);
      paramInt = i;
      if (this.TUW != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TUW);
      }
      i = paramInt + g.a.a.b.b.a.bM(7, this.Oms) + g.a.a.b.b.a.bM(8, this.TXB);
      paramInt = i;
      if (this.OmF != null) {
        paramInt = i + g.a.a.b.b.a.g(100, this.OmF);
      }
      AppMethodBeat.o(91641);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(91641);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        drd localdrd = (drd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91641);
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
            localdrd.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(91641);
          return 0;
        case 2: 
          localdrd.TXA = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 3: 
          localdrd.Ine = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 4: 
          localdrd.TWH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91641);
          return 0;
        case 5: 
          localdrd.DgI = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91641);
          return 0;
        case 6: 
          localdrd.TUW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(91641);
          return 0;
        case 7: 
          localdrd.Oms = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91641);
          return 0;
        case 8: 
          localdrd.TXB = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(91641);
          return 0;
        }
        localdrd.OmF = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(91641);
        return 0;
      }
      AppMethodBeat.o(91641);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drd
 * JD-Core Version:    0.7.0.1
 */