package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bmg
  extends dyl
{
  public String EBW;
  public String SXh;
  public int SXi;
  public String city;
  public String gbn;
  public int msgType;
  public String province;
  public String ybP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(269635);
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
      if (this.SXh != null) {
        paramVarArgs.f(4, this.SXh);
      }
      if (this.province != null) {
        paramVarArgs.f(5, this.province);
      }
      if (this.city != null) {
        paramVarArgs.f(6, this.city);
      }
      if (this.EBW != null) {
        paramVarArgs.f(7, this.EBW);
      }
      paramVarArgs.aY(8, this.msgType);
      paramVarArgs.aY(9, this.SXi);
      AppMethodBeat.o(269635);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label748;
      }
    }
    label748:
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
      if (this.SXh != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SXh);
      }
      i = paramInt;
      if (this.province != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.province);
      }
      paramInt = i;
      if (this.city != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.city);
      }
      i = paramInt;
      if (this.EBW != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.EBW);
      }
      paramInt = g.a.a.b.b.a.bM(8, this.msgType);
      int j = g.a.a.b.b.a.bM(9, this.SXi);
      AppMethodBeat.o(269635);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(269635);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        bmg localbmg = (bmg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(269635);
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
            localbmg.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(269635);
          return 0;
        case 2: 
          localbmg.gbn = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(269635);
          return 0;
        case 3: 
          localbmg.ybP = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(269635);
          return 0;
        case 4: 
          localbmg.SXh = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(269635);
          return 0;
        case 5: 
          localbmg.province = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(269635);
          return 0;
        case 6: 
          localbmg.city = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(269635);
          return 0;
        case 7: 
          localbmg.EBW = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(269635);
          return 0;
        case 8: 
          localbmg.msgType = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(269635);
          return 0;
        }
        localbmg.SXi = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(269635);
        return 0;
      }
      AppMethodBeat.o(269635);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bmg
 * JD-Core Version:    0.7.0.1
 */