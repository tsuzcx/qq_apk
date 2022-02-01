package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cbc
  extends dyl
{
  public String Kmh;
  public String Tju;
  public String Tjv;
  public String Tjw;
  public String fKO;
  public String jDL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(261479);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fKO != null) {
        paramVarArgs.f(2, this.fKO);
      }
      if (this.Kmh != null) {
        paramVarArgs.f(3, this.Kmh);
      }
      if (this.Tju != null) {
        paramVarArgs.f(4, this.Tju);
      }
      if (this.jDL != null) {
        paramVarArgs.f(5, this.jDL);
      }
      if (this.Tjv != null) {
        paramVarArgs.f(6, this.Tjv);
      }
      if (this.Tjw != null) {
        paramVarArgs.f(7, this.Tjw);
      }
      AppMethodBeat.o(261479);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label652;
      }
    }
    label652:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fKO != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fKO);
      }
      i = paramInt;
      if (this.Kmh != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.Kmh);
      }
      paramInt = i;
      if (this.Tju != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Tju);
      }
      i = paramInt;
      if (this.jDL != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.jDL);
      }
      paramInt = i;
      if (this.Tjv != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Tjv);
      }
      i = paramInt;
      if (this.Tjw != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Tjw);
      }
      AppMethodBeat.o(261479);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(261479);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cbc localcbc = (cbc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(261479);
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
            localcbc.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(261479);
          return 0;
        case 2: 
          localcbc.fKO = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(261479);
          return 0;
        case 3: 
          localcbc.Kmh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(261479);
          return 0;
        case 4: 
          localcbc.Tju = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(261479);
          return 0;
        case 5: 
          localcbc.jDL = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(261479);
          return 0;
        case 6: 
          localcbc.Tjv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(261479);
          return 0;
        }
        localcbc.Tjw = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(261479);
        return 0;
      }
      AppMethodBeat.o(261479);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbc
 * JD-Core Version:    0.7.0.1
 */