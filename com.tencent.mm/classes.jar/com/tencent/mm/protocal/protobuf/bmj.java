package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmj
  extends dyl
{
  public int SXi;
  public String city;
  public String gbn;
  public int msgType;
  public String province;
  public String ybP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(268988);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.gbn != null) {
        paramVarArgs.f(2, this.gbn);
      }
      if (this.ybP != null) {
        paramVarArgs.f(3, this.ybP);
      }
      if (this.province != null) {
        paramVarArgs.f(4, this.province);
      }
      if (this.city != null) {
        paramVarArgs.f(5, this.city);
      }
      paramVarArgs.aY(6, this.msgType);
      paramVarArgs.aY(7, this.SXi);
      AppMethodBeat.o(268988);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label624;
      }
    }
    label624:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gbn != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.gbn);
      }
      i = paramInt;
      if (this.ybP != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ybP);
      }
      paramInt = i;
      if (this.province != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.province);
      }
      i = paramInt;
      if (this.city != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.city);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.msgType);
      int j = g.a.a.b.b.a.bM(7, this.SXi);
      AppMethodBeat.o(268988);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(268988);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bmj localbmj = (bmj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(268988);
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
            localbmj.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(268988);
          return 0;
        case 2: 
          localbmj.gbn = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(268988);
          return 0;
        case 3: 
          localbmj.ybP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(268988);
          return 0;
        case 4: 
          localbmj.province = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(268988);
          return 0;
        case 5: 
          localbmj.city = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(268988);
          return 0;
        case 6: 
          localbmj.msgType = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(268988);
          return 0;
        }
        localbmj.SXi = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(268988);
        return 0;
      }
      AppMethodBeat.o(268988);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmj
 * JD-Core Version:    0.7.0.1
 */