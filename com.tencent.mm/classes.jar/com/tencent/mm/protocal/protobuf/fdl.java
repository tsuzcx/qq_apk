package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fdl
  extends dyl
{
  public int SmH;
  public long TVZ;
  public int TWa;
  public String UDq;
  public com.tencent.mm.cd.b UDr;
  public com.tencent.mm.cd.b UDs;
  public String UDt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125498);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.UDq == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: ToBizUserName");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.UDs == null)
      {
        paramVarArgs = new g.a.a.b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(125498);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.TWa);
      if (this.UDq != null) {
        paramVarArgs.f(3, this.UDq);
      }
      paramVarArgs.aY(4, this.SmH);
      if (this.UDr != null) {
        paramVarArgs.c(5, this.UDr);
      }
      if (this.UDs != null) {
        paramVarArgs.c(6, this.UDs);
      }
      paramVarArgs.bm(7, this.TVZ);
      if (this.UDt != null) {
        paramVarArgs.f(8, this.UDt);
      }
      AppMethodBeat.o(125498);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label764;
      }
    }
    label764:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.TWa);
      paramInt = i;
      if (this.UDq != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.UDq);
      }
      i = paramInt + g.a.a.b.b.a.bM(4, this.SmH);
      paramInt = i;
      if (this.UDr != null) {
        paramInt = i + g.a.a.b.b.a.b(5, this.UDr);
      }
      i = paramInt;
      if (this.UDs != null) {
        i = paramInt + g.a.a.b.b.a.b(6, this.UDs);
      }
      i += g.a.a.b.b.a.p(7, this.TVZ);
      paramInt = i;
      if (this.UDt != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.UDt);
      }
      AppMethodBeat.o(125498);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.UDq == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: ToBizUserName");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        if (this.UDs == null)
        {
          paramVarArgs = new g.a.a.b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(125498);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125498);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fdl localfdl = (fdl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125498);
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
            localfdl.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(125498);
          return 0;
        case 2: 
          localfdl.TWa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125498);
          return 0;
        case 3: 
          localfdl.UDq = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(125498);
          return 0;
        case 4: 
          localfdl.SmH = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(125498);
          return 0;
        case 5: 
          localfdl.UDr = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(125498);
          return 0;
        case 6: 
          localfdl.UDs = ((g.a.a.a.a)localObject).abFh.iUw();
          AppMethodBeat.o(125498);
          return 0;
        case 7: 
          localfdl.TVZ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(125498);
          return 0;
        }
        localfdl.UDt = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(125498);
        return 0;
      }
      AppMethodBeat.o(125498);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fdl
 * JD-Core Version:    0.7.0.1
 */