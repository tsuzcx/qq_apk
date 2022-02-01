package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpw
  extends dyl
{
  public String Txc;
  public String Txd;
  public String Txe;
  public String query;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153288);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Txc != null) {
        paramVarArgs.f(2, this.Txc);
      }
      if (this.query != null) {
        paramVarArgs.f(3, this.query);
      }
      if (this.Txd != null) {
        paramVarArgs.f(4, this.Txd);
      }
      if (this.Txe != null) {
        paramVarArgs.f(5, this.Txe);
      }
      paramVarArgs.aY(6, this.source);
      AppMethodBeat.o(153288);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label576;
      }
    }
    label576:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Txc != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Txc);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.query);
      }
      paramInt = i;
      if (this.Txd != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Txd);
      }
      i = paramInt;
      if (this.Txe != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Txe);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.source);
      AppMethodBeat.o(153288);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153288);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cpw localcpw = (cpw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153288);
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
            localcpw.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(153288);
          return 0;
        case 2: 
          localcpw.Txc = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 3: 
          localcpw.query = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 4: 
          localcpw.Txd = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153288);
          return 0;
        case 5: 
          localcpw.Txe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153288);
          return 0;
        }
        localcpw.source = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(153288);
        return 0;
      }
      AppMethodBeat.o(153288);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpw
 * JD-Core Version:    0.7.0.1
 */