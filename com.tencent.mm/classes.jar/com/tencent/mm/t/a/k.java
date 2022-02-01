package com.tencent.mm.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyl;
import com.tencent.mm.protocal.protobuf.jg;
import java.util.LinkedList;

public final class k
  extends dyl
{
  public String appId;
  public String jDR;
  public String jDS;
  public String uxInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(249257);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appId != null) {
        paramVarArgs.f(2, this.appId);
      }
      if (this.jDR != null) {
        paramVarArgs.f(3, this.jDR);
      }
      if (this.uxInfo != null) {
        paramVarArgs.f(4, this.uxInfo);
      }
      if (this.jDS != null) {
        paramVarArgs.f(5, this.jDS);
      }
      AppMethodBeat.o(249257);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label528;
      }
    }
    label528:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.appId);
      }
      i = paramInt;
      if (this.jDR != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.jDR);
      }
      paramInt = i;
      if (this.uxInfo != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.uxInfo);
      }
      i = paramInt;
      if (this.jDS != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.jDS);
      }
      AppMethodBeat.o(249257);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(249257);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        k localk = (k)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(249257);
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
            localk.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(249257);
          return 0;
        case 2: 
          localk.appId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249257);
          return 0;
        case 3: 
          localk.jDR = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249257);
          return 0;
        case 4: 
          localk.uxInfo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(249257);
          return 0;
        }
        localk.jDS = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(249257);
        return 0;
      }
      AppMethodBeat.o(249257);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.t.a.k
 * JD-Core Version:    0.7.0.1
 */