package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class faf
  extends dyl
{
  public int GIo;
  public String ProductID;
  public String TVo;
  public String TVp;
  public int TVq;
  public String TVr;
  public eae UAf;
  public int UAg;
  public int UAh;
  public String UAi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91722);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UAf == null)
      {
        paramVarArgs = new b("Not all required fields were included: Receipt");
        AppMethodBeat.o(91722);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.UAf != null)
      {
        paramVarArgs.oE(2, this.UAf.computeSize());
        this.UAf.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.f(3, this.ProductID);
      }
      paramVarArgs.aY(4, this.UAg);
      paramVarArgs.aY(5, this.GIo);
      if (this.TVo != null) {
        paramVarArgs.f(6, this.TVo);
      }
      if (this.TVp != null) {
        paramVarArgs.f(7, this.TVp);
      }
      if (this.TVr != null) {
        paramVarArgs.f(8, this.TVr);
      }
      paramVarArgs.aY(9, this.UAh);
      if (this.UAi != null) {
        paramVarArgs.f(10, this.UAi);
      }
      paramVarArgs.aY(11, this.TVq);
      AppMethodBeat.o(91722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UAf != null) {
        paramInt = i + g.a.a.a.oD(2, this.UAf.computeSize());
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ProductID);
      }
      i = i + g.a.a.b.b.a.bM(4, this.UAg) + g.a.a.b.b.a.bM(5, this.GIo);
      paramInt = i;
      if (this.TVo != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.TVo);
      }
      i = paramInt;
      if (this.TVp != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.TVp);
      }
      paramInt = i;
      if (this.TVr != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.TVr);
      }
      i = paramInt + g.a.a.b.b.a.bM(9, this.UAh);
      paramInt = i;
      if (this.UAi != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.UAi);
      }
      i = g.a.a.b.b.a.bM(11, this.TVq);
      AppMethodBeat.o(91722);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UAf == null)
        {
          paramVarArgs = new b("Not all required fields were included: Receipt");
          AppMethodBeat.o(91722);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        faf localfaf = (faf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91722);
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
            localfaf.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eae();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eae)localObject2).dd((byte[])localObject1);
            }
            localfaf.UAf = ((eae)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 3: 
          localfaf.ProductID = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 4: 
          localfaf.UAg = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91722);
          return 0;
        case 5: 
          localfaf.GIo = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91722);
          return 0;
        case 6: 
          localfaf.TVo = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 7: 
          localfaf.TVp = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 8: 
          localfaf.TVr = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 9: 
          localfaf.UAh = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(91722);
          return 0;
        case 10: 
          localfaf.UAi = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(91722);
          return 0;
        }
        localfaf.TVq = ((g.a.a.a.a)localObject1).abFh.AK();
        AppMethodBeat.o(91722);
        return 0;
      }
      AppMethodBeat.o(91722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.faf
 * JD-Core Version:    0.7.0.1
 */