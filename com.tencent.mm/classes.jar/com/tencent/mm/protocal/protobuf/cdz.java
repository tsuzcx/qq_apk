package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdz
  extends dyl
{
  public String RHW;
  public String RHs;
  public String extInfo;
  public int scene;
  public String uxInfo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(261262);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.uxInfo != null) {
        paramVarArgs.f(2, this.uxInfo);
      }
      paramVarArgs.aY(3, this.scene);
      if (this.RHs != null) {
        paramVarArgs.f(4, this.RHs);
      }
      if (this.RHW != null) {
        paramVarArgs.f(5, this.RHW);
      }
      if (this.extInfo != null) {
        paramVarArgs.f(6, this.extInfo);
      }
      AppMethodBeat.o(261262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.uxInfo != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.uxInfo);
      }
      i += g.a.a.b.b.a.bM(3, this.scene);
      paramInt = i;
      if (this.RHs != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.RHs);
      }
      i = paramInt;
      if (this.RHW != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.RHW);
      }
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.extInfo);
      }
      AppMethodBeat.o(261262);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(261262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cdz localcdz = (cdz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(261262);
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
            localcdz.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(261262);
          return 0;
        case 2: 
          localcdz.uxInfo = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(261262);
          return 0;
        case 3: 
          localcdz.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(261262);
          return 0;
        case 4: 
          localcdz.RHs = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(261262);
          return 0;
        case 5: 
          localcdz.RHW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(261262);
          return 0;
        }
        localcdz.extInfo = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(261262);
        return 0;
      }
      AppMethodBeat.o(261262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdz
 * JD-Core Version:    0.7.0.1
 */