package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ei
  extends dyl
{
  public String RDj;
  public String RJv;
  public int RJw;
  public String appid;
  public String fHp;
  public String signature;
  public String tyJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259216);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.f(2, this.appid);
      }
      if (this.RDj != null) {
        paramVarArgs.f(3, this.RDj);
      }
      if (this.tyJ != null) {
        paramVarArgs.f(4, this.tyJ);
      }
      if (this.signature != null) {
        paramVarArgs.f(5, this.signature);
      }
      if (this.fHp != null) {
        paramVarArgs.f(6, this.fHp);
      }
      if (this.RJv != null) {
        paramVarArgs.f(7, this.RJv);
      }
      paramVarArgs.aY(8, this.RJw);
      AppMethodBeat.o(259216);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label700;
      }
    }
    label700:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appid);
      }
      i = paramInt;
      if (this.RDj != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.RDj);
      }
      paramInt = i;
      if (this.tyJ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.tyJ);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.signature);
      }
      paramInt = i;
      if (this.fHp != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fHp);
      }
      i = paramInt;
      if (this.RJv != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.RJv);
      }
      paramInt = g.a.a.b.b.a.bM(8, this.RJw);
      AppMethodBeat.o(259216);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(259216);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ei localei = (ei)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259216);
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
            localei.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(259216);
          return 0;
        case 2: 
          localei.appid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(259216);
          return 0;
        case 3: 
          localei.RDj = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(259216);
          return 0;
        case 4: 
          localei.tyJ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(259216);
          return 0;
        case 5: 
          localei.signature = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(259216);
          return 0;
        case 6: 
          localei.fHp = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(259216);
          return 0;
        case 7: 
          localei.RJv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(259216);
          return 0;
        }
        localei.RJw = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(259216);
        return 0;
      }
      AppMethodBeat.o(259216);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ei
 * JD-Core Version:    0.7.0.1
 */